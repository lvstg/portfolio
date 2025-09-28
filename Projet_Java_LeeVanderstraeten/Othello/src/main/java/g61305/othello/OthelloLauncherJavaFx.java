package g61305.othello;

import g61305.othello.view.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class OthelloLauncherJavaFx extends Application {

    @Override
    public void start(Stage primaryStage)  {

        MainPane view = new MainPane(primaryStage);

        Scene scene = new Scene(view, 1200, 600);

        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("Othello");
        Image icon = new Image("logo-stage.jpg");
        primaryStage.getIcons().add(icon);


        primaryStage.setScene(scene);

        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(600);

        primaryStage.sizeToScene();

        primaryStage.show();
    }

}
