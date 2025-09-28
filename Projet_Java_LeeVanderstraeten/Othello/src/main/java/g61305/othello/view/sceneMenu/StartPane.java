package g61305.othello.view.sceneMenu;

import g61305.othello.controller.Controller;
import g61305.othello.model.Game;
import g61305.othello.view.sceneGame.GamePane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartPane extends VBox {
    private final Button startButton;
    private final ParameterBox parameterBox;
    private final Stage stage;
    public StartPane(Stage stage) {

        startButton = new Button("Start");

        parameterBox = new ParameterBox();
        this.stage = stage;

        getChildren().addAll(parameterBox, startButton);
        setAlignment(Pos.CENTER);

        changeScene();
        setOnEnterKey();
        startButton.prefWidthProperty().bind(parameterBox.getModeLabel().widthProperty().add(parameterBox.getModeChoice().widthProperty()));

        startButton.getStyleClass().add("button-style");
    }
    public int getSizeInput() {
        return parameterBox.getSizeBoardFieldValue();
    }
    public String getMode() {
        return parameterBox.getMode();
    }
    private void changeScene() {
        startButton.setOnAction(actionEvent -> {
            try {
                Game model = new Game(getSizeInput(), getMode());
                GamePane gamePane = new GamePane(stage, getSizeInput(), getMode());
                Controller controller = new Controller(model, gamePane);

                controller.initialize();

                Scene scene = new Scene(gamePane, stage.getWidth(),stage.getHeight());
                scene.getStylesheets().add("style.css");

                stage.setScene(scene);

            } catch (IllegalArgumentException e) {
                displayError(e.getMessage());
            }
        });
    }
    private void displayError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Table size information !");
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("style.css");

        ImageView imageView = new ImageView("cross-red-alert.png");
        imageView.setRotate(-45);
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);

        alert.setGraphic(imageView);

        alert.initStyle(StageStyle.TRANSPARENT);

        alert.showAndWait();
    }
    private void setOnEnterKey() {
        setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                startButton.fire();
            }
        });
    }
}
