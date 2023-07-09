package AdaShips;

public class Board {
  // Initialise the default board of 10 x 10 as an empty multi-dimensional array - a smaller version here to start
  // to test more easily
  Ship ships[];
  String cells[][] = { // A space character represents an empty cell for UI clarity
    {" ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " "}

  };
  int boardSize = 5;

  public void reset() { // Easy reset to initial state ready for new game/restart
    ships = null;
    ships = new Ship[1]; // Only one ship to be placed for now so easier to test
    ships[0] = new Ship();

    clearAllCoordinates();
    for(Ship ship : ships) {
      ship.unplace(); // To remove the ship's coordinates so resetting board
    }
  }

  // To Check: overloading of functions because of same name, is it OK?
  public void addShipToBoard(Coords[] newShipCoords, Ship ship) {
    for(int i = 0; i < newShipCoords.length; i++) { // It iterates over each coords and sets corresponding cells placing ships on board
      Coords coord = newShipCoords[i];
      cells[coord.y][coord.x] = ship.label; // To retrieve the ships and its corresponding name
    }
    ship.place();
  }

  public boolean coordsWithinBoard(Coords coord) { // If outside boundaries of board, will ask user to try again
    if(coord.x < 0 || coord.x >= boardSize || coord.y < 0 || coord.y >= boardSize) {
      return false;
    }
    return true;
  }

  public boolean cellEmpty(Coords coord) { // If the cell is not empty, it means there is a ship so invalid too
    if(!cells[coord.y][coord.x].equals(" ")) {
      return false;
    }
    return true;
  }

  public boolean isValidCoordinateToPlaceShip(Coords coord) { // By combining boundary validity above and cell emptiness, it adheres to game setting rules
    return coordsWithinBoard(coord) && cellEmpty(coord);
  }

  public void clearAllCoordinates() {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        cells[i][j] = " "; // Reset cell value to empty if user unhappy with settings
      }
    }
  }

    public boolean validCoordsForNewShip(Coords[] shipCoords, int shipLength){

      // To do: validate coords
      for (Coords coord : shipCoords) {
        if (!isValidCoordinateToPlaceShip(coord)) {
          return false;
        }
    }
      // Calculate distance between coords
      int distance = shipCoords.length;

      // Check distance is the same as ship length
      if (distance != shipLength) {
        return false;
      }

      // Not out of board
      return true;
    }
  }



