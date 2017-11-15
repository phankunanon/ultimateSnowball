package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
    private SpriteBatch batch;
    private SnowballGame snowballGame;
    private World world;
    private Texture playerImg;
    public static final int BLOCK_SIZE = 40;

    public WorldRenderer(SnowballGame snowballGame, World world) {
        this.snowballGame = snowballGame;
        batch = snowballGame.batch;
        this.world = world;
        playerImg = new Texture("player.png");
    }

    public void render(float delta) {
        SpriteBatch batch = snowballGame.batch;
        Vector2 pos = world.getPlayer().getPosition();
        batch.begin();
        batch.draw(playerImg, pos.x - BLOCK_SIZE/2,
                SnowballGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.end();
    }
}
