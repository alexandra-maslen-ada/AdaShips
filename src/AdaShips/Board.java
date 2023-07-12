package AdaShips;

import java.util.ArrayList;

public class Board {
  // Initialise the default board of 10 x 10 as an empty multi-dimensional array
  Ship ships[];
  String cells[][] = { // A space character represents an empty cell for UI clarity
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
  };
  int boardSize = 10;
  int numberOfHits = 0;

  public void reset() { // Easy reset to initial state ready for new game/restart
    numberOfHits = 0;
    ships = null;
    ships = new Ship[5]; // 5 ships are now available to be placed
    ships[0] = new Carrier();
    ships[1] = new Battleship();
    ships[2] = new Destroyer();
    ships[3] = new Submarine();
    ships[4] = new PatrolBoat();

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
    for(Ship ship : ships) {
      ship.unplace();
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

    public String fireTorpedo(Coords coords) { // Provide different round outcomes. Update game state by modifying
    // cell values and tracking number of hits
      String cellValue = cells[coords.y][coords.x];
      if (cellValue.equals(" ")) {
        cells[coords.y][coords.x] = "M";
        return "Missed";
      } else if (cellValue.equals("M")) {
        return "Missed";
      } else if (!cellValue.equals("H")) {
        cells[coords.y][coords.x] = "H";
        numberOfHits++;
        return "Hit";
      } else {
        return "Hit";
      }
    }

    public boolean isValidCoordinateToFireTorpedo(Coords coord) { // Check if coordinates are within board boundaries
      return coordsWithinBoard(coord);
    }

    public Boolean fleetSunk() { // Check status of fleet to determine winner
      return (numberOfHits > 0) && (numberOfHits >= getTotalShipCells());
    }

    public int getTotalShipCells() { // Only consider placed ships and their sizes to validate number of hits require to win
      int totalShipCells = 0;
      if (ships != null) {
        for (Ship ship : ships) {
          if (ship.isPlaced()) {
            totalShipCells += ship.getSize();
          }
        }
      }
      return totalShipCells;
    }

    public ArrayList<Coords> toListOfAvailableCoords() {
      ArrayList<Coords> coords = new ArrayList<Coords>();
      for (int i = 0; i < cells.length; i++) {
        for (int j = 0; j < cells[i].length; j++) {
          if (cells[i][j] == " ") {
            coords.add(new Coords(i, j));
          }
        }
      }
      return coords;
    }
  }



