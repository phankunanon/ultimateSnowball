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
            this.positionStatus ++;
        }
        else if(dir == DIRECTION_DOWN){
            this.positionStatus--;
        }
        if(this.positionStatus >= 3) this.positionStatus=2;
        if(this.positionStatus <0) this.positionStatus = 0;
        return;
    }

    public void status(int x){
        transform += x;
        transform %= 2;
        return ;
    }

    public void update() {
        move();
    }

    public Player(int x, int y, World world) {
        this.position = new Vector2(x,y);
        this.world = world;
    }

    public Vector2 getPosition() {
        return this.position;
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

    public void checkDeath(Vector2 rockpos){
        System.out.println("CHHHHH");
        System.out.print(rockpos.x);
        System.out.print("\t");
        System.out.println(rockpos.y);
        System.out.print(position.x);
        System.out.print("\t");
        System.out.print(position.y);
        if (abs(position.x -rockpos.x) <= 30 && position.y == rockpos.y){

            death = true;
        }
    }
}
