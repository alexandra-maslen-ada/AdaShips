package AdaShips;

import java.util.Scanner;

public class ScreenEnterSettings extends Screen {
    public static void render(Model model) { // Set up game such as ships' placement interactively with user or auto generate it
        boolean happyWithBoard = false;
        while (!happyWithBoard) { // Unless the user is happy with board, will be asked for their input
            Scanner scanner = new Scanner(System.in);

            for (Ship ship : model.player1.board.ships) { // Player can configure each ship individually
                boolean goodCoords = false;

                while (!goodCoords) { // Unless the ship's coords are valid, user will be prompted again
                    printSmallHeader();
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
                        System.out.println("Press any key to continue.");
                        System.out.print("OR type 'N' to replace the " + ship.name + " > ");
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
            printSmallHeader();
            printSingleBoard(model.player1);
            System.out.println("Are you happy with your board?.");
            System.out.print("Press any other key to continue, or 'N' to reset ships > ");
            String confirmation = scanner.nextLine().toUpperCase();
            if(confirmation.equalsIgnoreCase("N") || confirmation.equalsIgnoreCase("NO")) {
                model.player1.board.clearAllCoordinates(); // To allow user to clear their board and start again
            } else {
                happyWithBoard = true; // The user can finally start playing
            }
            model.gameState = Model.GameState.PLAYING;
        }
    }
}
