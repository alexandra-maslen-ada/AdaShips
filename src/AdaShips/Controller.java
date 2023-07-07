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
            switch( model.gameState ) { // Different actions can be taken depending on game state
                case START:         view.startScreen(model);
                    break;
                case QUIT:          playing = false;
                    break;
            }
        }
    }
}