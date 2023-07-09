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
      System.out.println("OK, let's start a new game.");
      model.gameState = Model.GameState.ENTER_SETTINGS;
    } else if (userInput.equals("QUIT")) {
      System.out.println("Oh no, you're leaving us too soon.");
      model.gameState = Model.GameState.QUIT;
    } else {
      System.out.println("Invalid input! Please try again."); // To cater for unexpected user input
    }
  }

  public void settingsScreen(Model model) { // Set up game such as ships' placement interactively with user or auto generate it
    boolean happyWithBoard = false;
    while (!happyWithBoard) { // Unless the user is happy with board, will be asked for their input
      Scanner scanner = new Scanner(System.in);

      for (Ship ship : model.player1.board.ships) { // Player can configure each ship individually
        boolean goodCoords = false;

        while (!goodCoords) { // Unless the ship's coords are valid, user will be prompted again
          printSingleBoard(model.player1);

          printListOfShips(model.player1.board.ships);

          System.out.println("Enter the coordinates for the " + ship.name + " (" + ship.length + " cells long) or press return twice to auto place:");

          String firstCoord = scanner.nextLine().toUpperCase(); // Define the ship placement input by user (e.g. A1)
          String secondCoord = scanner.nextLine().toUpperCase(); // 2 possible coordinates for one ship (e.g. A1 D1)

          Coords startCoords; // Ship can be placed horizontally or vertically, this would be e.g. A
          Coords endCoords; // Not initialized yet as depends on user's choice, this would be e.g. 1

          if (!firstCoord.isEmpty() && !secondCoord.isEmpty()) { // Validate coordinates if they are entered manually
            startCoords = parseCoordinates(firstCoord);
            endCoords = parseCoordinates(secondCoord);
          } else { // Generate random coordinates if the user does not enter them
            startCoords = model.createRandomCoords();
            endCoords = model.createRandomEndCoords(startCoords, ship.length); // This generates ship's position depending on length and where it starts

            Boolean randomGoodCoords = false;
            while(!randomGoodCoords) { // If these coords are not valid, they are generated again so ships are always placed correctly
              if (model.player1.board.validCoordsForNewShip(Ship.generateShipCoords(startCoords, endCoords), ship.length)) {
                randomGoodCoords = true;
              } else {
                startCoords = model.createRandomCoords();
                endCoords = model.createRandomEndCoords(startCoords, ship.length);
              }
            }
          }
          System.out.println("You have entered: '" + startCoords.toString() + " " + endCoords.toString() + "' for the " + ship.name + ".");

          Coords[] shipCoords = Ship.generateShipCoords(startCoords, endCoords); // Represent all the coordinates occupied by the ship instead of
          // 2 separate ones so easier to reuse

          if (model.player1.board.validCoordsForNewShip(shipCoords, ship.length)) {
            System.out.println("Are you happy with the coordinates of " + ship.name + "?. Type 'N' or press return to accept.");
            String confirmation = scanner.nextLine().toUpperCase();

            if (confirmation.equalsIgnoreCase("N") || confirmation.equalsIgnoreCase("NO")) {
              // As user wants to enter new coordinates, this deletes the ship's previous coordinates to start again
              System.out.println("Ok, please enter new coordinates for " + ship.name + ".");
            } else { // To accept different values of confirmation from user
              goodCoords = true;
              model.player1.board.addShipToBoard(shipCoords, ship);
            }
          } else {
            System.out.println("Your coordinates were not valid. Please try again.");
          }
        }
      }

      printSingleBoard(model.player1);
      System.out.println("Are you happy with your board?. Press 'N' to reset ships. Press any other key to continue.");
      String confirmation = scanner.nextLine().toUpperCase();
      if(confirmation.equalsIgnoreCase("N") || confirmation.equalsIgnoreCase("NO")) {
        model.player1.board.clearAllCoordinates(); // To allow user to clear their board and start again
      } else {
        happyWithBoard = true; // The user can finally start playing
      }
      model.gameState = Model.GameState.PLAYING;
    }
  }

  public void printSingleBoard(Player player1) {
    // Print column letters
    System.out.print("  ");
    for(int i = 0; i < player1.board.cells[0].length; i++) {
      System.out.print((char)('A'+ i) + "  ");
    }
    System.out.println();

    // Print board rows
    for(int i = 0; i < player1.board.cells.length; i++) {
      StringBuilder row = new StringBuilder();
      // Print row number
      row.append(i).append(" ");
      // Print board columns
      for (int j = 0; j < player1.board.cells[i].length; j++) {
        row.append(player1.board.cells[i][j] + "  ");
      }
      System.out.println(row);
    }
  }

  // Change user coords (e.g. B3) to coord object (e.g. x=1,y=3)
  private Coords parseCoordinates(String coordString) {
    char letter = Character.toUpperCase(coordString.charAt(0));
    int x = letter - 'A'; // Convert char to int
    int y = Integer.parseInt(coordString.substring(1));
    return new Coords(x, y);
  }

  public void printListOfShips(Ship[] ships) {
    System.out.println("Ships to place: ");
    for(Ship ship : ships) {
      if(!ship.isPlaced()) { // Only print the ships that are not placed so far by user
        System.out.println(" * " + ship.name + " " + ship.length);
      }
    }
  }

  public void playingScreen(Model model) {
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

  public void printPlayerBoards(Player player1, Player player2) { // Construct a formatted representation of boards
    // with the status of each cell in a visually aligned manner
    System.out.println("\t");
    System.out.println("      Your fleet             Enemy's fleet");
    System.out.print("  A B C D E F G H I J     A B C D E F G H I J\n");

    for (int i = 0; i < player1.board.cells.length; i++) {
      StringBuilder row = new StringBuilder();
      // Print row number
      row.append(i).append(" ");

      for (int j = 0; j < player1.board.cells[i].length; j++) {
        row.append(player1.board.cells[i][j] + " ");
      }
      row.append("\t" + (i)).append(" ");

      for (int j = 0; j < player2.board.cells[i].length; j++) {
        if (player2.board.cells[i][j].equals("M") || player2.board.cells[i][j].equals("H") || player2.board.cells[i][j].equals(" ") ) {
          row.append(player2.board.cells[i][j] + " "); // Increased spacing for better visual representation
        } else {
          row.append(" ");
        }
      }
      System.out.println(row);
    }
  }

  public void gameOverScreen(Model model) { // Handle end of game and allow user to replay or not
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
