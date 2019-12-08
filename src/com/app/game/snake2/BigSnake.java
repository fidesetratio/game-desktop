package com.app.game.snake2;

import com.app.game.snake2.model.Snake2;
import com.app.game.tutorial.input.GameInputProcessor;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BigSnake extends ApplicationAdapter {
	
	private SpriteBatch sb;

	private OrthographicCamera cam;
	private static int WIDTH;
	private static int HEIGHT;
	private Snake2 snake2;

	private static final float MOVE_TIME = .28f;
	private  float TIMER = MOVE_TIME;
	@Override
	public void create() {
		sb = new SpriteBatch();
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		cam = new OrthographicCamera();
		cam.setToOrtho(false,WIDTH, HEIGHT);
		sb = new SpriteBatch(); 
		this.snake2 = new Snake2();
		this.snake2.setCam(cam);
		Gdx.input.setInputProcessor(new GameInputProcessor());
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	@Override
	public void render() {
		
		float deltaTime = Gdx.graphics.getDeltaTime();
		this.TIMER -= deltaTime;
		snake2.handlingInput();
		if(this.TIMER<=0) { 
			snake2.move();
		    this.TIMER = MOVE_TIME; 
		};
	 	clearScreen();
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		snake2.draw(sb);
		sb.end();
	}
	public void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
}
