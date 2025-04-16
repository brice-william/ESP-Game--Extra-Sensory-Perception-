import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Random rand = new Random();
            StringBuilder gameResults = new StringBuilder(); // To store game results

            boolean playAgain = true;
            while (playAgain) {
                System.out.println("\nESP Game - Test Your ESP!");
                System.out.println("1. Play with 16 colors");
                System.out.println("2. Play with 10 colors");
                System.out.println("3. Play with 5 colors");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = input.nextInt();
                input.nextLine(); // Consume newline

                if (choice == 4) break;

                int limit = (choice == 1) ? 16 : (choice == 2) ? 10 : 5;
                String[] colors = new String[limit];

                try (Scanner fileScanner = new Scanner(new File("colors.txt"))) {
                    for (int i = 0; i < limit && fileScanner.hasNextLine(); i++)
                        colors[i] = fileScanner.nextLine().trim().toLowerCase();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: colors.txt not found.");
                    continue;
                }

                System.out.println("\nAvailable Colors:");
                for (String color : colors) System.out.println(color);

                int correctGuesses = 0;
                for (int i = 1; i <= 3; i++) {
                    String selectedColor = colors[rand.nextInt(colors.length)];
                    System.out.print("\nRound " + i + ": Guess the color: ");
                    String userGuess = input.nextLine().trim().toLowerCase();

                    if (userGuess.equals(selectedColor)) {
                        System.out.println("Correct!");
                        correctGuesses++;
                    } else {
                        System.out.println("Wrong! It was " + selectedColor + ".");
                    }
                }

                System.out.println("\nGame Over - You guessed " + correctGuesses + " out of 3 correctly.");
                gameResults.append("Game Result: ").append(correctGuesses).append(" out of 3 correct.\n");

                System.out.print("\nWould you like to play again? (yes/no): ");
                String response = input.nextLine().trim().toLowerCase();
                playAgain = response.equals("yes");
            }

            try (PrintWriter writer = new PrintWriter("EspGameResults.txt")) {
                System.out.print("\nEnter your name: ");
                String name = input.nextLine();
                System.out.print("Describe yourself: ");
                String description = input.nextLine();
                System.out.print("Due Date (MM/DD): ");
                String dueDate = input.nextLine();

                writer.println("Game Over");
                writer.println("Due Date: " + dueDate);
                writer.println("Username: " + name);
                writer.println("User Description: " + description);
                writer.println("\n--- Game Results ---");
                writer.println(gameResults);

                System.out.println("Results saved to EspGameResults.txt.");
            } catch (FileNotFoundException e) {
                System.out.println("Error writing results.");
            }

            System.out.println("Thanks for playing!");
        } // Scanner automatically closes here
    }
}
