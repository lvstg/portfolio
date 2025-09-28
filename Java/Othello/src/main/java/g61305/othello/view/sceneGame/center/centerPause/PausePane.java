package g61305.othello.view.sceneGame.center.centerPause;

import g61305.othello.view.MainPane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PausePane extends VBox {

    private final Button leaveButton;
    private final Button exitButton;
    private final Stage stage;

    public PausePane(Stage stage){
        Label pauseLabel = new Label("Pause");

        leaveButton = new Button("Menu");

        exitButton = new Button("Exit");



        this.stage = stage;

        getChildren().addAll(pauseLabel, leaveButton, exitButton);

        setAlignment(Pos.CENTER);

        setLeaveButton();
        setExitButton();

        setBackground(new Background(new BackgroundFill(
                Color.rgb(63, 102, 49, 0.7),
                null,
                null)));

        pauseLabel.getStyleClass().add("title-style");
        exitButton.getStyleClass().add("buttonBox-style");
        leaveButton.getStyleClass().add("buttonBox-style");

        setSpacing(30);
    }

    private void setLeaveButton() {
        leaveButton.setOnAction(actionEvent -> {
            MainPane mainPane = new MainPane(stage);
            Scene scene = new Scene(mainPane, stage.getWidth(), stage.getHeight());
            scene.getStylesheets().add("style.css");


            stage.setScene(scene);

        });
    }

    private void setExitButton() {
        exitButton.setOnAction(actionEvent -> Platform.exit());
    }

}
