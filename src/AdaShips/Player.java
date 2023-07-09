package AdaShips;

public class Player {
  // To store and assign names of players
  Board board;
  String name;

  Player(Board board, String name){ // To create players with different names
    this.board = board;
    this.name = name;
  }
}
