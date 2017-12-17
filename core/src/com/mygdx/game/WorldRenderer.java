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
        Vector2 pos1 = world.getPlayer().getPosition();
        Vector2 pos2 = world.getPlayer2().getPosition();
        Vector2 rockPos;
        player = world.getPlayer();
        player2 = world.getPlayer2();
        batch.begin();

        batch.draw(background,0,0,snowballGame.WIDTH,snowballGame.HEIGHT);


        if(!player.getDeath())
        {
            int x = player.transform;
            switch (x) {
                case 0:
                    batch.draw(playerImg, pos1.x, pos1.y);
                    break;
                case 1:
                    batch.draw(bungerplayerImg, pos1.x, pos1.y);
                    break;
            }
        }

        if(!player2.getDeath())
        {
            int x = player2.transform;
            switch (x) {
                case 0:
                    batch.draw(playerImg, pos2.x, pos2.y);
                    break;
                case 1:
                    batch.draw(bungerplayerImg, pos2.x, pos2.y);
                    break;
            }
        }

        List<Rocket> rock = world.getRocket();
        for(int i = 0 ;i < rock.size();i++){
            rockPos = rock.get(i).getPosition();
            batch.draw(rocketImg,rockPos.x,rockPos.y);
        }
        batch.end();
    }
}
