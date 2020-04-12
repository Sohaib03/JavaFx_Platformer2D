package main;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane anchorPane = new AnchorPane();

        GameEntities gameEntities = new GameEntities(anchorPane);

        Scene scene = new Scene(anchorPane, 600, 400);

        Controller controller = new Controller(scene);
        GameLoop gameLoop = new GameLoop(anchorPane, controller, gameEntities);
        gameLoop.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
