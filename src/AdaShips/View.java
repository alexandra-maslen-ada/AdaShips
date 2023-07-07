package AdaShips;

import java.util.Scanner; // To allow user input

public class View {
  public void startScreen(Model model) {
    // Display first screen of game and get user input to choose what to do next
    System.out.println("\nHello, let's play Adaships.\n");

    Scanner scanner = new Scanner(System.in);
    String userInput;

    System.out.println("Enter 'START' to play versus computer, or 'QUIT' to quit: ");
    userInput = scanner.nextLine().toUpperCase(); // To accept both lower and upper case inputs

    if (userInput.equals("START")) {
      System.out.println("Hello, let's start a game shortly once we have built it.");
      model.gameState = Model.GameState.QUIT;
    } else if (userInput.equals("QUIT")) {
      System.out.println("Oh no, you're leaving us too soon.");
      model.gameState = Model.GameState.QUIT;
    } else {
      System.out.println("Invalid input! Please try again."); // To cater for unexpected user input
    }
  }
}
