package AdaShips;

class Coords {
  public int x;
  public int y;

  // Constructor overloading to create object Coords with different values (one for int, one for char)
  public Coords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() { // Display coordinates in a readable format
    String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    return cols[x] + y;
  }
}