package g61305.othello.view;

import g61305.othello.view.sceneMenu.StartPane;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainPane extends GridPane {

    public MainPane(Stage stage) {
        StartPane startPane = new StartPane(stage);

        ImageView image = new ImageView("logo-menu.jpg");



        image.fitWidthProperty().bind(stage.widthProperty().divide(2));
        image.fitHeightProperty().bind(stage.heightProperty().divide(2));

        startPane.minHeightProperty().bind(stage.heightProperty().divide(2));
        startPane.minWidthProperty().bind(stage.widthProperty().divide(2));


        image.setPreserveRatio(true);
        add(image, 0, 0);
        add(startPane, 1, 0);

        getStyleClass().add("menu-background");

        setAlignment(Pos.CENTER);
    }
}
