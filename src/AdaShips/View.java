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
  // Is this the right place for this method below?
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

      for (int j = 0; j < player1.board.cells[i].length; j++) {
        row.append(player1.board.cells[i][j] + "  ");
      }
      System.out.println(row);
    }
  }

  // Helper method to parse the input coordinates and create Coords object
  private Coords parseCoordinates(String coordString) {
    char letter = Character.toUpperCase(coordString.charAt(0));
    int x = letter - 'A'; //* swap with x
    int y = Integer.parseInt(coordString.substring(1)); //* swap with y
    return new Coords(x, y);
  }

  public void printListOfShips(Ship[] ships) {
    System.out.println("Ships to place: ");
    for(Ship ship : ships) {
      if(!ship.isPlaced()) {
        System.out.println(" * " + ship.name + " " + ship.length);
      }
    }
  }
}
