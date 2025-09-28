package g61305.othello.view.sceneGame.center.centerPause;

import g61305.othello.view.sceneGame.center.centerBoard.BoardPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CenterPausePane extends StackPane {

    public CenterPausePane(BoardPane boardPane, Stage stage){
        PausePane pausePane = new PausePane( stage);
        this.getChildren().addAll(boardPane, pausePane);
    }
}
