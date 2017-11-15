package com.mygdx.game;

public class World {

    private Player player;
    private SnowballGame snowballGame;
    private int score;
    World(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        player = new Player(120,120,this);
    }
    Player getPacman() {
        return player;
    }
    public void update(float delta) {
        player.update();
    }
}
