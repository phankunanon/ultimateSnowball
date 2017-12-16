package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends ScreenAdapter {
    private SnowballGame snowballGame;
    private Texture playerImg;
    World world;
    WorldRenderer worldRenderer;

    public GameScreen(SnowballGame snowballGame) {
        this.snowballGame = snowballGame;
        world = new World(snowballGame);
        worldRenderer = new WorldRenderer(snowballGame,world);
    }

    private void update(float delta) {
        updatePlayerDirection();
        world.update(delta);
    }

    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        worldRenderer.render(delta);
    }

    private void updatePlayerDirection() {
        Player player = world.getPlayer();
        Player player2 = world.getPlayer2();

        if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            player.setNextDirection(Player.DIRECTION_UP);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            player.setNextDirection(Player.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            world.genRocket(player.getPosition(),1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            player.status(1);
        }


        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            player2.setNextDirection(Player.DIRECTION_UP);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            player2.setNextDirection(Player.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.V)) {
            world.genRocket(player2.getPosition(),2);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.L)){
            player2.status(1);
        }


    }

}
