package g61305.othello.view.sceneGame.center.centerEnd;

import g61305.othello.view.sceneGame.center.centerBoard.BoardPane;
import javafx.scene.layout.StackPane;

public class EndPane extends StackPane {

    private final WinnerPane winnerPane;

    public EndPane(BoardPane  boardPane){
        this.winnerPane = new WinnerPane();
        this.getChildren().addAll(boardPane, this.winnerPane);
    }

    public void setWinnerNameLabel(String nameLabel){
        this.winnerPane.setWinnerNameLabel(nameLabel);
    }
}
