package g61305.othello.view.sceneGame.center.centerBoard;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Cross extends StackPane {

    public Cross(double size, Stage stage){
        // Créer la première ligne diagonale (de haut à gauche à bas à droite)
        Line line1 = new Line();

        line1.endYProperty().bind(stage.heightProperty().divide(size).divide(3));
        line1.endXProperty().bind(stage.heightProperty().divide(size).divide(3));
        line1.strokeWidthProperty().bind(stage.heightProperty().divide(size).divide(10));

        line1.setStroke(Color.rgb(165, 0, 0));


        // Créer la deuxième ligne diagonale (de haut à droite à bas à gauche)
        Line line2 = new Line();

        line2.startXProperty().bind(stage.heightProperty().divide(size).divide(3));
        line2.endYProperty().bind(stage.heightProperty().divide(size).divide(3));
        line2.strokeWidthProperty().bind(stage.heightProperty().divide(size).divide(10));


        line2.setStroke(Color.rgb(165, 0, 0));

        getChildren().addAll(line1, line2);
    }
}
