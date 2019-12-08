package com.app.game.snake;

import com.app.game.snake.model.FullSnake;

public class PlaySnakeGameState extends SnakeGameState{
	
	private FullSnake fullSnake;
	
	public PlaySnakeGameState(SnakeGameStateManager gsm) {
		super(gsm);
		this.init();
	}

	@Override
	public void init() {
		fullSnake = new FullSnake();
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		fullSnake.draw(sb);
		sb.end();
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
