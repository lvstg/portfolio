package g61305.othello.view.sceneGame.playerPane;

import g61305.othello.controller.Controller;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class BotPane extends PlayerPane {

    private final ChoiceBox<String> modeChoice;
    public BotPane(String currentMode) {
        modeChoice = new ChoiceBox<>(FXCollections.observableArrayList(
                "human vs hard bot", "human vs easy bot"
        ));
        modeChoice.getSelectionModel().select(currentMode);

        add(modeChoice, 0, 4);

        modeChoice.getStyleClass().add("choice-box-style");
    }
    @Override
    public void initialize(Controller controller) {
        modeChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> controller.setMode(modeChoice.getSelectionModel().getSelectedItem()));
    }
}
