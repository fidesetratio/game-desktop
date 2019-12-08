package com.app.game.snake;

import com.app.game.tutorial.GameStateManager;
import com.app.game.tutorial.input.GameInputProcessor;
import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SnakeEngineAdapter extends ApplicationAdapter {

	

	private SpriteBatch sb;

	private OrthographicCamera cam;
	private static int WIDTH;
	private static int HEIGHT;

	private SnakeGameStateManager gsm;

	@Override
	public void create() {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		gsm = new SnakeGameStateManager(this);
		cam = new OrthographicCamera();
		cam.setToOrtho(false,WIDTH, HEIGHT);
		sb = new SpriteBatch();
		Gdx.input.setInputProcessor(new GameInputProcessor());
		this.gsm = new SnakeGameStateManager(this);
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		gsm.update(Gdx.graphics.getDeltaTime());
		clearScreen();
		gsm.draw();
		GameKeys.update();
	}
	public void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public OrthographicCamera getCam() {
		return cam;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}


	public SpriteBatch getSb() {
		return sb;
	}

	public void setSb(SpriteBatch sb) {
		this.sb = sb;
	}
}
