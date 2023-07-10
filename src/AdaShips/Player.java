package AdaShips;

import java.util.ArrayList;
import java.util.Random;

public class Player {
  // To store and assign names of players
  Board board;
  String name;
  ArrayList<Coords> shotHistory = new ArrayList<Coords>();
  Player(Board board, String name){ // To create players with different names
    this.board = board;
    this.name = name;
  }
  public void addToShotHistory(Coords coords){
    shotHistory.add(coords);
  }

  public String[] autoFireAt(Player enemy) { // To make decisions autonomously based on valid randomly generated coordinates
    ArrayList<Coords> availableCoordsList = enemy.board.toListOfAvailableCoords();
    availableCoordsList.removeAll(this.shotHistory);
    Coords[] availableCoords = availableCoordsList.toArray(new Coords[availableCoordsList.size()]);
    Random random = new Random();
    Coords coords = availableCoords[random.nextInt(availableCoords.length)];
    String shotResult = enemy.board.fireTorpedo(coords);
    addToShotHistory(coords);
    return new String[]{shotResult,coords.toString()};
  }
}
