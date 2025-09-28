package g61305.othello.view.sceneGame.playerPane;

import g61305.othello.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class PlayerPane extends GridPane {

    private final Label namePlayer;
    private final Label scoreLabel;
    private final Label statusLabel;
    private final Label priseNumberLabel;
    private boolean isCurrentPlayer;
    private final Circle colorCircle;

    public PlayerPane() {
        namePlayer = new Label("Player 1");

        colorCircle = new Circle(30, Color.BLACK);

        Label titleScoreLabel = new Label("Score");

        scoreLabel = new Label("0");

        statusLabel = new Label();
        isCurrentPlayer = false;

        Label priseLabel = new Label("Prise");
        priseNumberLabel = new Label("0");

        add(namePlayer, 0, 0);
        add(colorCircle, 1, 0);
        add(titleScoreLabel, 0, 1);
        add(scoreLabel, 1, 1);
        add(priseLabel, 0, 2);
        add(priseNumberLabel, 1, 2);
        add(statusLabel, 0, 3); // Déplacer les truc des player et bot

        namePlayer.getStyleClass().add("playerName-font");
        titleScoreLabel.getStyleClass().add("playerInfo-font");
        scoreLabel.getStyleClass().add("playerInfo-font");
        statusLabel.getStyleClass().add("play-wait-style");
        priseLabel.getStyleClass().add("playerInfo-font");
        priseNumberLabel.getStyleClass().add("playerInfo-font");

        setAlignment(Pos.TOP_CENTER);

        setPadding(new Insets(30));
        setHgap(20);
        setVgap(20);
        getStyleClass().add("playerPane-style");
    }

    public abstract void initialize(Controller controller);
    public void setCurrentPlayer(boolean isCurrentPlayer) {
        this.isCurrentPlayer = isCurrentPlayer;
        setStatusValue();
    }

    public boolean getIsCurrentPlayer() {
        return isCurrentPlayer;
    }

    public void setScoreLabel(String newScore) {
        scoreLabel.setText(newScore);
    }

    public void setPriseNumberLabel(int newPrise) {
        int currentPrise = Integer.parseInt(priseNumberLabel.getText());
        priseNumberLabel.setText(String.valueOf(currentPrise+newPrise));
    }

    public void setStatusValue() {
        String status = isCurrentPlayer ? "Your turn to play" : "You have to wait";
        statusLabel.setText(status);
    }

    public int getScoreLabel() {
        return Integer.parseInt(scoreLabel.getText());
    }

    public String getNamePlayer() {return namePlayer.getText();
    }

    public void setNamePlayer(String newName)
    {
        colorCircle.setFill(Color.WHITE);
        namePlayer.setText(newName);
    }


}
