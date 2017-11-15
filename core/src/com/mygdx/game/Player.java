package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;

    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_DOWN = 2;
    private static final int [] DIR_OFFSETS = new int [] {1,3,5};

    private static int positionStatus;
    private World world;
    public static final int POSITION = 100;
    public void move() {
        position.y = POSITION * DIR_OFFSETS[positionStatus];
    }

    public void setNextDirection(int dir) {
        if (dir == DIRECTION_UP){
            positionStatus ++;
        }
        else if(dir == DIRECTION_DOWN){
            positionStatus--;
        }
        if(positionStatus >= 3) positionStatus=2;
        if(positionStatus <0) positionStatus = 0;
        return;
    }

    public void update() {
        move();
    }

    public Player(int x, int y, World world) {
        position = new Vector2(x,y);
        this.world = world;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void shoot() {

    }
}
