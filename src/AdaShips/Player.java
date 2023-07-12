package AdaShips;

import java.util.ArrayList;
import java.util.Random;

public class Player {
  // To store and assign names of players
  Board board;
  String name;
  ArrayList<String> shotHistory = new ArrayList<String>();
  Player(Board board, String name){ // To create players with different names
    this.board = board;
    this.name = name;
  }
  public void addToShotHistory(String coords){
    shotHistory.add(coords);
  }

  public String[] autoFireAt(Player enemy) { // To make decisions autonomously based on valid randomly generated coordinates
    ArrayList<String> availableCoordsList = enemy.board.toListOfAvailableCoords();
    availableCoordsList.removeAll(this.shotHistory);
    String[] availableCoords = availableCoordsList.toArray(new String[availableCoordsList.size()]);
    Random random = new Random();
    Coords coords = Screen.parseCoordinates(availableCoords[random.nextInt(availableCoords.length)]);
    String shotResult = enemy.board.fireTorpedo(coords);
    addToShotHistory(coords.toString());
    return new String[]{shotResult,coords.toString()};
  }
}
