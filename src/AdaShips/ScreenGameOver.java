package AdaShips;

import java.util.Scanner;

public class ScreenGameOver extends Screen {
    public static void render(Model model) { // Handle end of game and allow user to replay or not
        printSmallHeader();
        System.out.println("Game over");

        System.out.println(model.winner.name + " wins!");

        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Enter '1' to replay, or 'quit' to exit: ");
        userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            model.gameState = Model.GameState.ENTER_SETTINGS;
            model.setUpNewGame();
        } else if (userInput.equals("quit")) {
            model.gameState = Model.GameState.QUIT;
        } else {
            System.out.println("Invalid input! Please try again.");
        }
    }
}
