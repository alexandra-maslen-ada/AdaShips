package AdaShips;

public class Controller {
    // Handle the game logic and interaction between model and view
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        run(); // Control main game loop based on the state chosen by user
    }

    public void run (){
        Boolean playing = true;
        while (playing) {
            model.updateGameState();
            switch( model.gameState ) { // Different actions can be taken depending on game state
                case START:         view.startScreen(model);
                    break;
                case ENTER_SETTINGS:  view.settingsScreen(model);
                    break;
                case PLAYING:        view.playingScreen(model);
                break;
                case FINISHED:      System.out.println("Game over");
                                    playing = false;
                    break;
                case QUIT:          playing = false; // Break the look to simply exit the game
                    break;
            }
        }
    }
}