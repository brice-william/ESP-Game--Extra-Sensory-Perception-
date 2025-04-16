## ESP Game (Extra Sensory Perception)
This simple Java console-based game was created as part of a CMSC203 class project. The game challenges the user to test their "ESP" (Extra Sensory Perception) by guessing randomly selected colors from a list.

### 📋 Description

When the game runs, the player chooses between three game modes using different sets of colors:

  - 16 colors
  - 10 colors
  - 5 colors

For each round, the program randomly selects a color from the list, and the user tries to guess it. The game repeats for 3 rounds, and the user's score is tracked. At the end of the session, the program collects the user’s name, description, and due date, then saves the results to a file called `EspGameResults.txt`.

### 🎯 Features
- Multiple game modes (varying color set sizes)
- Random color selection
- Score tracking across games
- Option to replay
- Saves results to a file
- User interaction through the console

### 🛠 Requirements
- Java 8 or later
- A `colors.txt` file in the same directory with a list of color names (one per line)

###🚀 How to Run
1. Make sure you have `Main.java` and a valid `colors.txt` in the same directory.

2. Compile the file:

    ```bash
    javac Main.java
    ```

3. Run the program:

    ```bash
    java Main
    ```
### 📝 Notes
-Be sure to create or download a `colors.txt` file with at least 16 color names if you want to use the 16-color mode.
-The game results will be saved to `EspGameResults.txt.`
