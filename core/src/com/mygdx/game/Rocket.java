package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
    private static final int SPEED = 13;
    private SnowballGame snowballGame;
    private World world;
    private Player player;
    public Vector2 position;

    public void move() {
        position.x += SPEED;
    }

    public Rocket(float x, float y, World world) {
        position = new Vector2(x,y);
        this.world = world;
    }
    public void update() {
        move();
    }

    public boolean checkStatus(){
        Vector2 pos = getPosition();
        if(pos.x >= snowballGame.WIDTH || pos.y >= snowballGame.HEIGHT){
            player.countShoot--;
            return true;
        }
        return false;
    }

    public Vector2 getPosition() {
        return position;
    }
}
