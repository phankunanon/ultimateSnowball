package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_STILL = 0;
    private static final int [][] DIR_OFFSETS = new int [][] {
            {0,0},
            {0,-1},
            {0,1}
    };
    private int currentDirection;
    private int nextDirection;
    private World world;

    public void update() {
    }

    public Player(int x, int y, World world) {
        position = new Vector2(x,y);
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
        this.world = world;
    }

    public Vector2 getPosition() {
        return position;
    }

}
