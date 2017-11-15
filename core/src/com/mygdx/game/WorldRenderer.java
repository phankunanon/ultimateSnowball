package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
    private SpriteBatch batch;
    private SnowballGame snowballGame;
    private World world;
    private Texture playerImg;
    private Texture rocketImg;

    public WorldRenderer(SnowballGame snowballGame, World world) {
        this.snowballGame = snowballGame;
        batch = snowballGame.batch;
        this.world = world;
        playerImg = new Texture("player.png");
        rocketImg = new Texture("rocket.png");
    }

    public void render(float delta) {
        SpriteBatch batch = snowballGame.batch;
        Vector2 pos = world.getPlayer().getPosition();
        //Vector2 rockPos = world.getRocket().getPosition();
        batch.begin();
        batch.draw(playerImg, pos.x ,pos.y);
        //batch.draw(rocketImg,rockPos.x,rockPos.y);
        batch.end();
    }
}
