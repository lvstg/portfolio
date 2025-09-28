package g61305.othello.console;

import g61305.othello.model.Game;
import org.jetbrains.annotations.NotNull;


public class Controller {
    private final Game model;
    private final View view;
    
    public Controller(@NotNull Game model,@NotNull View view){
        this.model = model;
        this.view = view;
    }

    public void start() {
        addFirstPiece();
        while(model.getGameStatus()){
            view.displayBoard(model);

            view.displayScores(model);
            view.displayCurrentPlayer(model);
            int newPiece = view.testEntier("Where do you want to place your piece ? ");
            try {
                model.add(newPiece);
            }catch (NullPointerException e){
                view.displayError("You can only choose the red numbers.");
            }

        }
        view.displayBoard(model);
        view.displayWinner(model.findWinner());
    }

    public void addFirstPiece() {
        model.addFirstPiece();
    }
}
