package com.app.game.snake;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class SnakeGameState {
	
	protected SnakeGameStateManager gsm;
	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	
	
	protected  SnakeGameState(SnakeGameStateManager gsm) {
		this.gsm = gsm;
		if(gsm.getEngineAdapter().getSb() != null) {
			sb = gsm.getEngineAdapter().getSb();
		}
		if(gsm.getEngineAdapter().getCam() != null) {
			cam = gsm.getEngineAdapter().getCam();
		}
	}
	
	public abstract void init();
	public abstract void update(float dt);
	public abstract void draw();
	public abstract void handleInput(); // generally di pangil update
	public abstract void dispose(); // untuk beda state

}
