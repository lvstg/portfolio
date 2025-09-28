package g61305.othello.view.sceneGame;

import g61305.othello.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

class ButtonBox extends HBox {

    private final Button menuButton;
    private final Button continueButton;
    private final Button pauseButton;

    private final Button undo;

    private final Button redo;

    ButtonBox() {
        continueButton = new Button("Continue");
        menuButton = new Button("Menu");
        pauseButton = new Button("Pause");
        undo = new Button("Undo");
        redo = new Button("Redo");

        undo.getStyleClass().add("buttonBox-style");
        redo.getStyleClass().add("buttonBox-style");
        pauseButton.getStyleClass().add("buttonBox-style");
        menuButton.getStyleClass().add("buttonBox-style");
        continueButton.getStyleClass().add("buttonBox-style");


        getChildren().addAll(undo, pauseButton, redo);

        setAlignment(Pos.CENTER);

        setSpacing(20);

        setMinHeight(100);
    }


    public Button getContinueButton() {
        return continueButton;
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public Button getPauseButton() {
        return pauseButton;
    }

    public void setButton(String newButton) {
        getChildren().clear();
        switch (newButton) {
            case "menu" -> getChildren().add(menuButton);
            case "pause" -> getChildren().addAll(undo, pauseButton, redo);
            case "continue" -> getChildren().add(continueButton);
        }
    }

    public void initialize(Controller controller) {
        setOnKeyPressed(keyEvent -> {
            if (keyEvent.isControlDown()) {
                switch (keyEvent.getCode()) {
                    case Y -> controller.redo(); // ctrl+Y
                    case Z -> controller.undo(); // ctrl+Z
                }
            }
        });
        undo.setOnAction(actionEvent -> controller.undo());
        redo.setOnAction(actionEvent -> controller.redo());
    }
}
