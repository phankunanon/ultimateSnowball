package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
    private static final int SPEED = 13;
    private SnowballGame snowballGame;
    private World world;
    private Player player = world.getPlayer();
    private Player player2 = world.getPlayer2();
    public Vector2 position;

    public void move() {
        this.position.x += SPEED;
    }

    public Rocket(float x, float y, World world) {
        this.position = new Vector2(x,y);
        this.world = world;
    }
    public void update() {
        move();
    }

    public boolean checkStatus(){
        Vector2 pos = getPosition();
        if(pos.x >= snowballGame.WIDTH){
            player.countShoot--;
            return true;
        }
        if(pos.x <= 0){
            player2.countShoot--;
            return true;
        }
        return false;
    }

    public Vector2 getPosition() {
        return position;
    }
}
