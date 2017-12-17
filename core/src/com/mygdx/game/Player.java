package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.abs;

public class Player {

    private Vector2 position;
    public int transform = 0;
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_DOWN = 2;
    public int countShoot = 0;
    private static final int [] DIR_OFFSETS = new int [] {1,3,5};

    public int hp = 5;
    public int canTransfrom = 5;

    private int positionStatus;
    private World world;
    private Rocket rocket;
    private boolean death = false;
    public static final int POSITION = 100;

    public void move() {
        this.position.y = POSITION * DIR_OFFSETS[positionStatus];
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

    public void status(int x){
        if(canTransfrom == 0){
            return;
        }
        transform += x;
        transform %= 2;
        if(transform == 0){
            canTransfrom--;
        }
        return ;
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

    public boolean canShoot(int cnt) {
        if(cnt >= 3 || transform == 1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean shoot() {
        if(canShoot(countShoot)) {
            countShoot++;
            return true;
        }
        return false;
    }

    public boolean getDeath(){
        return death;
    }

    public boolean checkDeath(Vector2 rockpos) {
        if (abs(position.x - rockpos.x) <= 30 && position.y == rockpos.y && hp > 0) {
            if(transform==0){
                hp--;
            }
            if (hp <= 0) {
                death = true;
            }

            return true;
        }
        return false;
    }
}

