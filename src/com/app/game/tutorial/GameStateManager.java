package com.app.game.tutorial;

import com.app.game.tutorial.states.GameState;
import com.app.game.tutorial.states.PlayState;

public class GameStateManager {
	private GameState gameState;

	private Tutorial tutorial;
	public static final int MENU = 0;
	public static final int PLAY = 8888;
	
	public GameStateManager() {
		setState(PLAY);
	}
	
	public GameStateManager(Tutorial tutorial) {
		this.tutorial = tutorial;
		setState(PLAY);
	}
	
	public void setState(int state) {
		
		if(gameState != null) {
			gameState.dispose();
		}
		if(state == MENU) {
			//switch to menu
		}
		if(state == PLAY) {
			// switch to play
			this.gameState = new PlayState(this);
		}
	}

	
	public void update(float dt) {
			this.gameState.update(dt);
	}
	
	public void draw() {
		this.gameState.draw();
	}
	
	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	
}
