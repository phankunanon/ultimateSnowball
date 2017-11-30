package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.xml.soap.Text;
import java.util.List;

public class WorldRenderer {
    private SpriteBatch batch;
    private SnowballGame snowballGame;
    private World world;
    private Player player;
    private Player player2;
    private Texture playerImg;
    private Texture rocketImg;
    private Texture background;
    private Texture bungerplayerImg;
    public WorldRenderer(SnowballGame snowballGame, World world) {
        this.snowballGame = snowballGame;
        batch = snowballGame.batch;
        this.world = world;
        playerImg = new Texture("player.png");
        rocketImg = new Texture("rocket.png");
        background = new Texture("bgsnow.jpg");
        bungerplayerImg = new Texture("bunger1.png");
    }

    public void render(float delta) {
        SpriteBatch batch = snowballGame.batch;
        Vector2 pos = world.getPlayer().getPosition();
        Vector2 rockPos;
        player = world.getPlayer();
        player2 = world.getPlayer2();
        batch.begin();

        batch.draw(background,0,0,snowballGame.WIDTH,snowballGame.HEIGHT);


        //if(!player.getDeath())
        {
            int x = player.transform;
            switch (x) {
                case 0:
                    batch.draw(playerImg, pos.x, pos.y);
                    break;
                case 1:
                    batch.draw(bungerplayerImg, pos.x, pos.y);
                    break;
            }
        }

        pos = player2.getPosition();
        System.out.println(player2.getDeath());
        if(!player2.getDeath())
            batch.draw(playerImg,pos.x,pos.y);

        List<Rocket> rock = world.getRocket();
        for(int i = 0 ;i < world.getcntRocket();i++){
            rockPos = rock.get(i).getPosition();
            batch.draw(rocketImg,rockPos.x,rockPos.y);
        }
        batch.end();
    }
}
