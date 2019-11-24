package com.app.game.tutorial;

import com.app.game.tutorial.input.GameInputProcessor;
import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tutorial extends ApplicationAdapter {


	private SpriteBatch sb;
	


	private static int WIDTH;
	private static int HEIGHT;

	
	private GameStateManager gsm;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();/*
											 * cam = new OrthographicCamera(WIDTH,HEIGHT);
											 */
		/*
		 * cam.translate(WIDTH/2, HEIGHT/2); cam.update();
		 */
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false,WIDTH, HEIGHT);
		sb = new SpriteBatch();
		Gdx.input.setInputProcessor(new GameInputProcessor());
		this.gsm = new GameStateManager(this);
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
		
		/*
		 * if(GameKeys.isPressed(GameKeys.SHIFT)) { System.out.println("SHIFT PRESED");
		 * } if(GameKeys.isPressed(GameKeys.ENTER)) {
		 * System.out.println("ENTER PRESED"); }
		 */
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		GameKeys.update();
		
	}
	public SpriteBatch getSb() {
		return sb;
	}
	public void setSb(SpriteBatch sb) {
		this.sb = sb;
	}
	
	
	public OrthographicCamera getCam() {
		return cam;
	}
	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}
	private OrthographicCamera cam;
	
	
	
}
