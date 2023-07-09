package AdaShips;

import java.util.Random;

public class Model {
  enum GameState {
    // To organise and manage the flow of the game and different stages
    START, ENTER_SETTINGS, PLAYING, FINISHED, QUIT
  }

  public GameState gameState;
  public Player player1;
  public Player player2;
  public Player currentPlayer;

  Model(){
    this.gameState = GameState.START; // Control point for managing game
    player1 = new Player(new Board(), "Alex");
    player2 = new Player(new Board(), "Computer");
    currentPlayer = player1;
  }

  public void updateGameState() { // Initialisation steps
    if (gameState.equals(GameState.ENTER_SETTINGS)) {
      setUpNewGame();
    }
  }

  public void setUpNewGame() { // Reset board to initial state for new game
    player1.board.reset();
    player2.board.reset();
    computerPlacesShips(); // Randomly place ships
    currentPlayer = player1;
  }

  public void computerPlacesShips() { // Automate process of placing ships and mark them as placed
    for (Ship ship : player2.board.ships) {
      Coords[] shipCoords = calculateCoordsForComputerShip(player2.board, ship.getSize());
      player2.board.addShipToBoard(shipCoords, ship);
      ship.place();
    }
  }

  public Coords[] calculateCoordsForComputerShip(Board board, int shipLength) { //Repeatedly generates random coordinates
    // until valid ones are found
    Coords[] shipCoords = new Coords[0];
    Boolean goodCoords = false;

    while(!goodCoords) {
      Coords startCoords = createRandomCoords();
      Coords endCoords = createRandomEndCoords(startCoords, shipLength);
      shipCoords = Ship.generateShipCoords(startCoords, endCoords);

      if (board.validCoordsForNewShip(shipCoords, shipLength)) {
        goodCoords = true;
      }
    }
    return shipCoords;
  }



  public Coords createRandomCoords() {
    Random random = new Random();
    int row = random.nextInt(10); // Generate random row index (0-9)
    int col = random.nextInt(10); // Generate random column index (0-9)
    Coords coords = new Coords(row, col);
    return coords;
  }

  public Coords createRandomEndCoords(Coords startCoords, int shipLength) { // Randomly determines whether ship
    // should be placed horizontally or vertically based on how long a ship is
    Coords endCoords = new Coords(startCoords.x, startCoords.y);
    Random random = new Random();
    int randomValue = random.nextInt(2);
    if (randomValue == 0) {
      endCoords.x += shipLength-1; // As starting coordinate is considered as one position, adjustment positions end accurately
    } else {
      endCoords.y += shipLength-1;
    }
    return endCoords;
  }
}







