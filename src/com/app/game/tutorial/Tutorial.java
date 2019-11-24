package com.app.game.tutorial;

import com.app.game.tutorial.input.GameInputProcessor;
import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tutorial extends Game {
	private SpriteBatch batch;
	


	private static int WIDTH;
	private static int HEIGHT;
	
	private OrthographicCamera cam;
	
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		cam =  new OrthographicCamera(WIDTH,HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(GameKeys.isPressed(GameKeys.SHIFT)) {
			System.out.println("SHIFT PRESED");
		}
		if(GameKeys.isPressed(GameKeys.ENTER)) {
			System.out.println("ENTER PRESED");
		}
		GameKeys.update();
		
	}
}
