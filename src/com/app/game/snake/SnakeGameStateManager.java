package com.app.game.snake;

import com.app.game.tutorial.Tutorial;

public class SnakeGameStateManager {
	
	
	
	public static final int MENU = 0;
	public static final int PLAY = 8888;
	private SnakeGameState gameState;
	
	


	protected SnakeEngineAdapter engineAdapter;
	
	
	
	public SnakeGameStateManager() {
		setState(PLAY);
	}
	
	public SnakeGameStateManager(SnakeEngineAdapter engineAdapter) {
		this.engineAdapter = engineAdapter;
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
			this.gameState = new PlaySnakeGameState(this);
		}
	}

	
	
	
	
	
	
	public SnakeEngineAdapter getEngineAdapter() {
		return engineAdapter;
	}

	public void setEngineAdapter(SnakeEngineAdapter engineAdapter) {
		this.engineAdapter = engineAdapter;
	}
	
	public void update(float dt) {
		this.gameState.update(dt);
	}

	public void draw() {
		this.gameState.draw();
	}

	
}
