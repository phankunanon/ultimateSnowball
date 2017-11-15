package com.mygdx.game;

public class World {

    private Player player;
    private SnowballGame snowballGame;

    World(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        player = new Player(120,200,this);
    }

    Player getPlayer() {
        return player;
    }

    public void update(float delta) {
        player.update();
    }
}
