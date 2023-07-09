package AdaShips;

public class Controller {
    // Handle the game logic and interaction between model and view
    private Model model;

    public Controller(Model model) {
        this.model = model;
        run(); // Control main game loop based on the state chosen by user
    }

    public void run (){
        Boolean playing = true;
        while (playing) {
            model.updateGameState();
            switch( model.gameState ) { // Different actions can be taken depending on game state
                case START:          ScreenStart.render(model);
                                     break;
                case ENTER_SETTINGS: ScreenEnterSettings.render(model);
                                     break;
                case PLAYING:        ScreenPlaying.render(model);
                                     break;
                case FINISHED:       ScreenGameOver.render(model);
                                     break;
                case QUIT:           playing = false; // Break the look to simply exit the game
                                     break;
            }
        }
    }
}
