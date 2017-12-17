package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Player player;
    private Player player2;
    private SnowballGame snowballGame;
    private List<Rocket> rockets = new ArrayList<Rocket>();
    private List<Player> playerlist = new ArrayList<Player>();
    World(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        player = new Player(120,0,this);
        player2 = new Player(1000,100,this);
        playerlist.add(player);
        playerlist.add(player2);
    }

    Player getPlayer() {
        return player;
    }
    Player getPlayer2() {
        return player2;
    }

    public void genRocket(Vector2 pos,int whoshoot){
        Rocket rock;
        if( whoshoot == 1 && player.shoot()) {
            rock = new Rocket(pos.x+40, pos.y, this,1);
            rockets.add(rock);
        }
        if(whoshoot == 2 && player2.shoot()) {
            rock = new Rocket(pos.x-40, pos.y, this,2);
            rockets.add(rock);
        }
    }

    public void update(float delta) {

        System.out.print("Player1 : ");
        System.out.println(player.countShoot);
        System.out.print("Player2 : ");
        System.out.println(player2.countShoot);
        for (int i = 0;i<rockets.size();i++) {
            rockets.get(i).update();
            boolean chcol = false;
            chcol = chcol | player2.checkDeath(rockets.get(i).getPosition());
            chcol = chcol |player.checkDeath(rockets.get(i).getPosition());
            boolean chdel = rockets.get(i).checkStatus();
            if(chdel || chcol){
                playerlist.get(rockets.get(i).who-1).countShoot--;
                rockets.remove(i);
            }
        }
        player.update();
        player2.update();
    }
    public List<Rocket> getRocket() {
        return rockets;
    }
}
