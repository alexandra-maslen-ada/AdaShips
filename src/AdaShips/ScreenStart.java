package AdaShips;

import java.util.Scanner;

public class ScreenStart extends Screen {
    public static void render(Model model) {
        // Display first screen of game and get user input to choose what to do next
        printBigHeader();

        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Enter any key to play versus computer, or type 'QUIT' to quit: ");
        userInput = scanner.nextLine().toUpperCase(); // To accept both lower and upper case inputs

        if (userInput.equals("")) {
            model.gameState = Model.GameState.ENTER_SETTINGS;
        } else if (userInput.equals("QUIT")) {
            System.out.println("Oh no, you're leaving us too soon.");
            model.gameState = Model.GameState.QUIT;
        } else {
            System.out.println("Invalid input! Please try again."); // To cater for unexpected user input
        }
    }
}
