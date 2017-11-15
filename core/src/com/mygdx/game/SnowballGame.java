package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SnowballGame extends Game {
    public SpriteBatch batch;
    public static final int HEIGHT = 720;
    public static final int WIDTH = 1250;

    public void create(){
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }

    public void render(){
        super.render();
    }

    public void  dispose(){
        batch.dispose();
    }
}
