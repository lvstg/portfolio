package g61305.othello.view.sceneGame.playerPane;

import g61305.othello.controller.Controller;
import javafx.scene.control.Button;


public class HumanPane extends PlayerPane {
    private final Button giveUpButton;

    public HumanPane() {
        giveUpButton = new Button("Give Up");

        add(giveUpButton, 0, 4);

        giveUpButton.getStyleClass().add("giveUp-style");
    }

    @Override
    public void initialize(Controller controller) {
        giveUpButton.setOnAction(actionEvent -> {
            if (getIsCurrentPlayer()) {
                controller.giveUp();
            }
        });
    }

}
