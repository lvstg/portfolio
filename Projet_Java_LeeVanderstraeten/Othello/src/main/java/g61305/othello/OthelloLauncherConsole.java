package g61305.othello;

import g61305.othello.console.Controller;
import g61305.othello.model.Game;
import g61305.othello.console.View;

public class OthelloLauncherConsole {

    public static void main(String[] args) {
        View view = new View();
        Game model = new Game(view.testBorne("What size board do you want? ", 3, 15), "human vs human");
        Controller controller = new Controller(model, view);
        controller.start();
    }
}
