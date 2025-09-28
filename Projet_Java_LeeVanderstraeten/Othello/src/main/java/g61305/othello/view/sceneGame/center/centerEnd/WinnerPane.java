package g61305.othello.view.sceneGame.center.centerEnd;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

public class WinnerPane extends VBox {
    private final Label winnerNameLabel;

    public WinnerPane() {
        Label winnerLabel = new Label("WINNER");
        Label isLabel = new Label("is");
        this.winnerNameLabel = new Label();
        this.getChildren().addAll(winnerLabel, isLabel, winnerNameLabel);

        this.setBackground(new Background(new BackgroundFill(
                Color.rgb(63, 102, 49, 0.7)
                , null
                , null)));

        this.setAlignment(Pos.CENTER);

        winnerLabel.getStyleClass().add("title-style");
        isLabel.getStyleClass().add("is-style");
        this.winnerNameLabel.getStyleClass().add("winnerName-style");
    }

    void setWinnerNameLabel(String nameLabel) {
        this.winnerNameLabel.setText(nameLabel);
    }
}
