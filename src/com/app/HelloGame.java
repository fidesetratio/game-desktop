package com.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends Game {
	
	SpriteBatch batch;
	private HelloGameScreen screen;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		screen = new HelloGameScreen(this, batch);
		setScreen(screen);
		
	
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		batch.dispose();
		
	}

	@Override
	public void render() {
		
		super.render();
	}

}
