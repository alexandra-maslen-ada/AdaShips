package AdaShips;

public abstract class Ship { // This provides functionality to get how long a ship is, whether it is placed and
  // change status on board accordingly
  protected int length;
  public String name = "Ship";
  private boolean placed = false;
  public String label = "S";

  public int getSize() {
    return length;
  }

  public boolean isPlaced() {
    return placed;
  }

  public void place() {
    this.placed = true;
  }

  public void unplace() {
    this.placed = false;
  }

  static public Coords[] generateShipCoords(Coords startCoords, Coords endCoords) {

    // if both Xs are the same - draw horizontal ship
    if (startCoords.x == endCoords.x) {
      int length = (endCoords.y - startCoords.y) + 1;
      Coords[] coords = new Coords[length];
      for (int i = 0; i <= length - 1; i++) {
        coords[i] = new Coords(startCoords.x, i + startCoords.y);
      }
      return coords;
    } else if (startCoords.y == startCoords.y) {
      // if both Ys are the same - draw vertical ship
      int length = (endCoords.x - startCoords.x) + 1;
      Coords[] coords = new Coords[length];
      for (int i = 0; i <= length - 1; i++) {
        coords[i] = new Coords(i + startCoords.x, startCoords.y );
      }
      return coords; // new created coords array

    } else {
      // create Coords array with no length, to fail validation
      Coords[] coords = new Coords[0];
      return coords;
    }
  }
}
