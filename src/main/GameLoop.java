package main;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;

public class GameLoop extends AnimationTimer {

    private AnchorPane gamePane;
    private Controller controller;
    private GameEntities gameEntities;
    private Player player;
    private int g_acc = 4;

    public GameLoop(AnchorPane gamePane, Controller controller, GameEntities gameEntities) {
        this.gamePane = gamePane;
        this.controller = controller;
        this.gameEntities = gameEntities;
        player = gameEntities.player;
    }


    @Override
    public void handle(long now) {
        if (controller.isLeftKeyPressed()) {
            if (player.direction == 1) {
                player.getPlayerImage().setScaleX(-1);
                player.direction = -1;
            }
            player.getPlayerImage().setLayoutX(player.getPlayerImage().getLayoutX() - 2);

        }
        if (controller.isRightKeyPressed()) {
            if (player.direction == -1) {
                player.getPlayerImage().setScaleX(1);
                player.direction = 1;
            }
            player.getPlayerImage().setLayoutX(player.getPlayerImage().getLayoutX() + 2);

        }

        if (player.grounded && controller.isUpKeyPressed()) {
            player.velocity_y = 80;
            player.grounded = false;
        }

        if (!player.grounded) {
            player.getPlayerImage().setLayoutY(player.getPlayerImage().getLayoutY() - (double)player.velocity_y/12);
        }
        gravity();

        collision_handle();

    }

    private void gravity() {
        if (!player.grounded) {
            player.velocity_y -= g_acc;
        }

        if (player.getPlayerImage().getLayoutY() > 200) player.grounded = true;
    }

    private void collision_handle() {

        int px1 = (int)player.getPlayerImage().getLayoutX();
        int py1 = (int)player.getPlayerImage().getLayoutY();
        int px2 = px1 + player.WIDTH;
        int py2 = py1 + player.HEIGHT;

        for (Block block : gameEntities.blocks) {
            if (block == null) continue;
            // top collision
            int bx1 = block.getPosX();
            int by1 = block.getPosY();
            int bx2 = bx1 + block.getWidth();
            int by2 = by1 + block.getHeight();

            if (px2>bx1 && px2<bx2 && py2 > by1 && py2 < by2) {
                System.out.println("Collsion -> "+ Integer.toString((int) px1) + " " + Integer.toString(px2));
            }

        }
    }

}
