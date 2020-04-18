package main;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Player {

    ImageView playerImage;

    public int direction = 1;
    public boolean grounded = false;

    public int velocity_x;
    public int velocity_y;

    public int WIDTH = 42;
    public int HEIGHT = 66;

    public Player() {
        playerImage = new ImageView();
        Animation runAnimation = new SpriteAnimation(playerImage, "/resources/run/", "run", Duration.millis(700), 8);
        runAnimation.setCycleCount(Animation.INDEFINITE);
        runAnimation.play();

        playerImage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 10, 0, 0, 0);");
    }

    public ImageView getPlayerImage() {
        return playerImage;
    }
}
