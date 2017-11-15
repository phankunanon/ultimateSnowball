package com.mygdx.game;

public class World {

    private Player player;
    private Rocket rocket;
    private SnowballGame snowballGame;

    World(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        player = new Player(120,0,this);
    }

    Player getPlayer() {
        return player;
    }


    public void update(float delta) {
        player.update();
    }

    Rocket getRocket() {
        return rocket;
    }
}
