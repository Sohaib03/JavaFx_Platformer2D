package main;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;

public class GameLoop extends AnimationTimer {

    private AnchorPane gamePane;
    private Controller controller;
    private GameEntities gameEntities;
    private Player player;

    public GameLoop(AnchorPane gamePane, Controller controller, GameEntities gameEntities) {
        this.gamePane = gamePane;
        this.controller = controller;
        this.gameEntities = gameEntities;
        player = gameEntities.player;
    }


    @Override
    public void handle(long now) {
        if (controller.isLeftKeyPressed())
        {
            player.getPlayerImage().setLayoutX(player.getPlayerImage().getLayoutX() - 2);
        }
        if (controller.isRightKeyPressed())
            player.getPlayerImage().setLayoutX(player.getPlayerImage().getLayoutX() + 2);

    }
}
