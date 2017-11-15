package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket {
    private static final int SPEED =5;
    private World world;
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
    public Vector2 getPosition() {
        return position;
    }
}
