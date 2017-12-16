package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Player player;
    private Player player2;
    private SnowballGame snowballGame;
    private List<Rocket> rockets = new ArrayList<Rocket>();
    World(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        player = new Player(120,0,this);
        player2 = new Player(500,100,this);
    }

    Player getPlayer() {
        return player;
    }
    Player getPlayer2() {
        return player2;
    }

    public void genRocket(Vector2 pos,int whoshoot){
        Rocket rock;
        if(player.shoot() && whoshoot == 1) {
            rock = new Rocket(pos.x+40, pos.y, this);
            rockets.add(rock);
        }
        if(player2.shoot() && whoshoot == 2) {
            rock = new Rocket(pos.x+40, pos.y, this);
            rockets.add(rock);
        }
    }
    public void update(float delta) {

        for (int i = 0;i<rockets.size();i++) {
            rockets.get(i).update();
            player2.checkDeath(rockets.get(i).getPosition());
            player.checkDeath(rockets.get(i).getPosition());
            boolean chdel = rockets.get(i).checkStatus();
            if(chdel){
                rockets.remove(i);
            }
        }
        player.update();
        player2.update();
    }
    public int getcntRocket(){
        return rockets.size();
    }
    public List<Rocket> getRocket() {
        return rockets;
    }
}
