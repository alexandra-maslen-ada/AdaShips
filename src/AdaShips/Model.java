package AdaShips;

public class Model {
  enum GameState {
    // To organise and manage the flow of the game and different stages
    START, ENTER_SETTINGS, PLAYING, FINISHED, QUIT
  }

  public GameState gameState;
  public Player player1;
  public Player player2;
  public Player currentPlayer;
  public Player winner;

  Model(){
    this.gameState = GameState.START; // Control point for managing game
    player1 = new Player("Alex");
    player2 = new Player("Computer");
    currentPlayer = player1;
  }

}







