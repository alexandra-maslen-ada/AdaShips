package AdaShips;

class Coords {
  public int x;
  public int y;

  // This is for coords made automatically
  public Coords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // This is for coords made from a user input
  public Coords(String x, int y) {
    this.x = x.charAt(0) - 'A';
    this.y = y;
  }

  public String toString() { // Display coordinates in a readable format
    String[] cols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    return cols[x] + y;
  }
}