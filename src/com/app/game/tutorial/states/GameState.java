package com.app.game.tutorial.states;

import com.app.game.tutorial.GameStateManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState {
	protected GameStateManager gsm;
	
	protected SpriteBatch sb;
	
	protected OrthographicCamera cam;
	
	
	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		if(gsm.getTutorial().getSb() != null) {
			sb = gsm.getTutorial().getSb();
		}
		if(gsm.getTutorial().getCam() != null) {
			cam = gsm.getTutorial().getCam();
		}
	}
	
	
	public abstract void init();
	public abstract void update(float dt);
	public abstract void draw();
	public abstract void handleInput(); // generally di pangil update
	public abstract void dispose(); // untuk beda state

}
