package g61305.othello.view.sceneGame.center.centerBoard;

import javafx.animation.FadeTransition;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

/**
 * Represents a cell in the table.
 */

class CaseBox extends StackPane {

    private final Circle circle;

    private final int position;

    private final Rectangle rectangle;

    private final Cross cross;

    CaseBox(int position, Stage stage, double size){
        double hauteur = stage.getHeight();
        double diametre = hauteur / size;
        double radius = diametre / 3;
        this.position = position;

        circle = new Circle(radius, Color.rgb(63, 102, 49, 1));
        circle.radiusProperty().bind(stage.heightProperty().divide(size).divide(3));

        rectangle = new Rectangle(diametre/2, diametre/2);
        rectangle.heightProperty().bind(stage.heightProperty().divide(size).divide(2));
        rectangle.widthProperty().bind(stage.heightProperty().divide(size).divide(2));
        rectangle.setFill(Color.TRANSPARENT);


        setBackground(new Background(
                new BackgroundFill(
                        Color.rgb(63, 102, 49, 1),
                        null,
                        null
                )
        ));
        cross = new Cross(size, stage);

        this.getChildren().addAll(circle, cross, rectangle);
        cross.setVisible(false);

        this.setBorder(new Border(new BorderStroke(
                BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(0.5))));


    }

    int getPosition() {
        return position;
    }

    void setPossibleMove(){
        circle.setFill(Color.rgb(255, 0, 0, 0.2));
    }
    void setGreen(){
        circle.setFill( Color.rgb(63, 102, 49, 1));
        circle.setStroke( Color.rgb(63, 102, 49, 1));
    }
    void setWhite(){
        circle.setFill(WHITE);
        circle.setStroke(WHITE);
    }
    void setBlack(){
        circle.setFill( Color.rgb(16, 16, 16, 1));
        circle.setStroke(Color.rgb(16, 16, 16, 1));
    }
    void setStroke() {
        this.circle.setStroke(Color.rgb(0, 0, 255, 1));
    }
    public void setWall() {
        rectangle.setFill(Color.rgb(149, 147, 148));
        setGreen();
    }
    public void wrongCase() {

        cross.setVisible(true);

        // Créer une FadeTransition pour créer un effet de disparition
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), cross);

        // Configuration de la transition
        fadeTransition.setFromValue(1.0); // Opacité de départ (complètement opaque)
        fadeTransition.setToValue(0.0); // Opacité de fin (complètement invisible)

        // Jouer la transition pour créer l'effet de disparition
        fadeTransition.play();


    }


}
