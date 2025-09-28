package g61305.othello.view.sceneMenu;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

class ParameterBox extends GridPane {

    private final Label modeLabel;

    private final Label sizeBoardLabel;

    private final ChoiceBox<String> modeChoice;

    private final TextField sizeBoardField;

    public ParameterBox(){
        modeLabel = new Label("Difficulty");

        sizeBoardLabel = new Label("Board size");

        modeChoice = new ChoiceBox<>(FXCollections.observableArrayList(
                "human vs hard bot","human vs easy bot", "human vs human"
        ));
        modeChoice.getSelectionModel().selectFirst();

        //Alignement
        setAlignment(Pos.CENTER);

        //Padding
        Insets insets = new Insets(20);
        modeLabel.setPadding(insets);
        sizeBoardLabel.setPadding(insets);

        sizeBoardField = new TextField();
        sizeBoardField.setPromptText("Between 3 and 15.");


        add(modeLabel, 0, 0);
        add(modeChoice, 1, 0);
        add(sizeBoardLabel, 0, 1);
        add(sizeBoardField, 1, 1);

        filtreSizeBoardField();

        modeLabel.getStyleClass().add("label-style");
        sizeBoardLabel.getStyleClass().add("label-style");
        modeChoice.getStyleClass().add("choice-box-style");
        sizeBoardField.getStyleClass().add("field-style");

        modeChoice.minWidthProperty().bind(sizeBoardField.widthProperty());
    }
    int getSizeBoardFieldValue() {
        if (sizeBoardField.getText().isEmpty()){
            return -1;
        }
        return Integer.parseInt(sizeBoardField.getText());
    }
    String getMode() {
        return modeChoice.getValue();
    }
    private void filtreSizeBoardField(){
        sizeBoardField.addEventFilter(KeyEvent.KEY_TYPED, keyEvent -> {
            if (!keyEvent.getCharacter().matches("[0-9]")){
                keyEvent.consume();
            }
        });
    }

    public Label getModeLabel() {
        return modeLabel;
    }

    public ChoiceBox<String> getModeChoice(){
        return modeChoice;
    }
}
