package main;

import javafx.scene.layout.AnchorPane;

public class GameEntities {

    public AnchorPane gamePane;
    public Player player;
    public Block[] blocks;

    public GameEntities(AnchorPane gamePane){
        this.gamePane = gamePane;
        blocks = new Block[3];
        addGameItems();
    }

    private void addGameItems() {
        player = new Player();
        player.getPlayerImage().setLayoutX(20);
        player.getPlayerImage().setLayoutY(150);
        gamePane.getChildren().add(player.getPlayerImage());

        blocks[0] = new Block(gamePane, 5, 5, 0, 266);
        blocks[1] = new Block(gamePane, 7, 8, 80, 152+66);

    }


}
