package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends ScreenAdapter {
    private SnowballGame snowballGame;
    private Texture snowballImg;
    World world;
    WorldRenderer worldRenderer;

    public GameScreen(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        snowballImg = new Texture("player.png");
        world = new World(snowballGame);
        worldRenderer = new WorldRenderer(snowballGame,world);
    }
    private void update(float delta) {
        world.update(delta);
    }
    public void render(float delta) {
        update(delta);
        worldRenderer.render(delta);
    }

}
