package g61305.othello.view.sceneGame.center.centerBoard;

import g61305.othello.controller.Controller;
import g61305.othello.model.Move;
import g61305.othello.model.State;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Represents the table for the view.
 */

public class BoardPane extends GridPane {

    public BoardPane(int size, Stage stage) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                CaseBox caseBox = new CaseBox(++count, stage, size);
                add(caseBox, col, row);
            }
        }

        setAlignment(Pos.CENTER);
    }
    public void update(State state, int newPiece) {
        for (Node node : this.getChildren()) {
            CaseBox caseBox = (CaseBox) node;
            if (state.getBlackPieces().contains(caseBox.getPosition())) {
                caseBox.setBlack();
            }else if (state.getWhitePieces().contains(caseBox.getPosition())) {
                caseBox.setWhite();
            } else if (state.getWallPosition().contains(caseBox.getPosition())) {
                caseBox.setWall();
            } else {
                caseBox.setGreen();
            }
            for (Move move : state.getPossibleMove()) {
                if (move.pieceToPlace() == caseBox.getPosition()) {
                    caseBox.setPossibleMove();
                }
            }
            if (caseBox.getPosition() == newPiece){
                caseBox.setStroke();
            }
        }
    }

    /**
     * Initialise the squares on the game board.
     * @param controller is the object that lets us add a piece to a cell in the table.
     */
    public void initialize(Controller controller) {

        for (Node node : this.getChildren()) {
            CaseBox caseBox = (CaseBox) node;
            caseBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        controller.addPiece(caseBox.getPosition());

                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        controller.addWall(caseBox.getPosition());
                    }
                }
            });
        }
    }

    public void wrongCaseBox(int position) {
        for (Node node : this.getChildren()) {
            CaseBox caseBox = (CaseBox) node;
            if (caseBox.getPosition() == position){
                caseBox.wrongCase();
            }
        }
    }
}
