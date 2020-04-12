package main;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Player {

    ImageView playerImage;

    public Player() {
        playerImage = new ImageView();
        Animation runAnimation = new SpriteAnimation(playerImage, "/resources/run/", "run", Duration.millis(700), 8);
        runAnimation.setCycleCount(Animation.INDEFINITE);
        runAnimation.play();
    }

    public ImageView getPlayerImage() {
        return playerImage;
    }
}
