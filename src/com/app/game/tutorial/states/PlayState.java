package com.app.game.tutorial.states;

import com.app.game.tutorial.GameStateManager;
import com.app.tutorial.object.Apple;
import com.app.tutorial.object.Monitor;
import com.app.tutorial.object.Snake;

public class PlayState extends GameState {
	
	private Apple apple;
	private Apple apple2;
	private Apple apple3;
	private Apple apple4;
	
	private Snake snake;
	private static final float MOVE_TIME = 1f; 
	private  float timer = MOVE_TIME;
	private Monitor monitor;
	public PlayState(GameStateManager gsm) {
		super(gsm);
		monitor = new Monitor(200,200);		
		apple = new Apple(100,100);
		apple.setName("apple1");
		apple2 = new Apple(200, 300);
		apple2.setName("apple2");
		apple3 = new Apple(100, 250);
		apple3.setName("apple3");
		apple4 = new Apple(200, 250);
		apple4.setName("apple4");
		snake = new Snake(0, 0, new Apple[] {apple,apple2,apple3,apple4},monitor);		
	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		/* System.out.println("update"+dt); */
	 //apple.update(dt);
	 //apple2.update(dt);
	 snake.update(dt);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		apple.draw(sb);
		apple2.draw(sb);
		apple3.draw(sb);
		apple4.draw(sb);
		monitor.draw(sb);
		snake.draw(sb);
		//snake.handlingInput();
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
