package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private Texture heartImg;
    private Texture snowmanStatusImg;
    private int scr[] = {80,120,160,200,240};
    private int hpY = 650;
    public WorldRenderer(SnowballGame snowballGame, World world) {
        this.snowballGame = snowballGame;
        batch = snowballGame.batch;
        this.world = world;
        playerImg = new Texture("player.png");
        rocketImg = new Texture("rocket.png");
        background = new Texture("bgsnow.jpg");
        bungerplayerImg = new Texture("bunger1.png");
        heartImg = new Texture ("hearts.png");
        snowmanStatusImg = new Texture("snowman.png");

    }

    public void render(float delta) {
        SpriteBatch batch = snowballGame.batch;
        BitmapFont font = new BitmapFont();
        Vector2 pos1 = world.getPlayer().getPosition();
        Vector2 pos2 = world.getPlayer2().getPosition();
        Vector2 rockPos;
        Vector2 snowmanStatusPos = new Vector2(50,25);
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

        for(int i = 0;i< player.hp;i++){
            batch.draw(heartImg,scr[i],hpY);
        }
        for(int i = 0;i< player2.hp;i++){
            batch.draw(heartImg,snowballGame.WIDTH-scr[i],hpY);
        }

        String statusPl1 = "x"+player.canTransfrom;
        String statusPl2 = "x"+player2.canTransfrom;
        batch.draw(snowmanStatusImg,snowmanStatusPos.x,snowmanStatusPos.y);
        font.setColor(Color.BLACK);
        font.getData().setScale(1.5f);
        font.draw(batch,statusPl1,snowmanStatusPos.x*2+30,snowmanStatusPos.y*2);
        batch.draw(snowmanStatusImg,snowballGame.WIDTH-(snowmanStatusPos.x)*5,snowmanStatusPos.y);
        font.draw(batch,statusPl2,snowballGame.WIDTH-(snowmanStatusPos.x*4)+30,snowmanStatusPos.y*2);

        if(player.getDeath()){
            font.draw(batch,"PLAYER1 so NOOB",snowballGame.WIDTH*2.3f/5,snowballGame.HEIGHT/2);
            font.draw(batch,"Press ESC to Close this Window",snowballGame.WIDTH*2.3f/5-50,snowballGame.HEIGHT/2-30);
        }
        else if(player2.getDeath()){
            font.draw(batch,"PLAYER2 so NOOB",snowballGame.WIDTH*2.3f/5,snowballGame.HEIGHT/2);
            font.draw(batch,"Press ESC to Close this Window",snowballGame.WIDTH*2.3f/5-50,snowballGame.HEIGHT/2-30);
        }

        batch.end();
    }
}
