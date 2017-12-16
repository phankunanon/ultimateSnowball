package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
    private static final int SPEED = 13;
    public int who = 0;
    private SnowballGame snowballGame;
    private World world;
    public Vector2 position;

    public void move() {
        if (who==2)
            this.position.x -= SPEED;
        else
            this.position.x += SPEED;
    }

    public Rocket(float x, float y, World world,int whoshoot) {
        this.position = new Vector2(x,y);
        this.world = world;
        this.who = whoshoot;
    }
    public void update() {
        move();
    }

    public boolean checkStatus(){
        Vector2 pos = getPosition();
        if(pos.x >= snowballGame.WIDTH || pos.x <=0){
            return true;
        }
        return false;
    }

    public Vector2 getPosition() {
        return this.position;
    }
}
