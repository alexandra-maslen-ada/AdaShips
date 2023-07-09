package AdaShips;

import java.util.Scanner; // To allow user input

public class ScreenPlaying extends Screen {

  public static void render(Model model) {
    System.out.println("One player v computer game");

    printPlayerBoards(model.player1, model.player2);

    Scanner scanner = new Scanner(System.in);

    if (model.currentPlayer.equals(model.player1)) {
      String userInput;

      System.out.println("Enter coordinates (e.g., A1, B2): for " + model.currentPlayer.name);
      userInput = scanner.nextLine().toUpperCase();

      if(userInput.equals("QUIT")) {
        System.out.println("Quitting the game.... Goodbye!");
        model.gameState = Model.GameState.QUIT;
      }
      else if (userInput.equals("")) {  // Auto create only valid coordinates when user chooses to
        Boolean goodRandomCoords = false;
        while (!goodRandomCoords) {
          Coords coords = model.createRandomCoords();
          if(model.player2.board.isValidCoordinateToPlaceShip(coords)) {
            goodRandomCoords = true;
            String torpedoResult = model.player2.board.fireTorpedo(coords);
            printPlayerBoards(model.player1, model.player2);
            System.out.println(torpedoResult);
            scanner.nextLine().toUpperCase();
            model.switchPlayer();
          }
        }
      }
      else { // Use coordinates given by user, update game state and switch players
        String col = userInput.substring(0); // Get the first character entered
        int row = Integer.parseInt(userInput.substring(1));  // Get the second character entered
        Coords coords = new Coords(col, row);
        if (model.player2.board.isValidCoordinateToFireTorpedo(coords)) {
          String torpedoResult = model.player2.board.fireTorpedo(coords);
          printPlayerBoards(model.player1, model.player2);
          System.out.println(torpedoResult);
          scanner.nextLine().toUpperCase();
          model.switchPlayer();
        }
        else {
          System.out.println("Invalid input! Please try again. Press any key to continue.");
          scanner.nextLine().toUpperCase();
        }
      }
    } else {
      // Randomly select coordinates for computer player
      System.out.println("One player v computer game");
      String computerShot = model.computerShoots();
      printPlayerBoards(model.player1, model.player2);
      System.out.println("Computer fired a torpedo: " + computerShot + " .Press any key to continue.");

      scanner.nextLine().toUpperCase();
      model.switchPlayer();
    }

  }

}
