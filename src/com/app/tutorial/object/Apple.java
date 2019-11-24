package com.app.tutorial.object;

import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Apple extends GameObject {
	
	
	private float dt;
	
	private static final float SPEED = 32f;
	private static final float MOVE_TIME = 0.5f;
	private  float TIMER = MOVE_TIME;
	private boolean move;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	
	public Apple() {
		super();
		this.init();
	}
	
	public Apple(float x, float y) {
		super();
		setPosition(x,y);
		this.init();
	}
	
	public void init() {
		this.texture = new Texture(Gdx.files.internal("resources/snake/apple.png"));
		bounds.setSize(this.texture.getWidth(), this.texture.getHeight());
		this.dt = 0f;
		this.move =false;
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stubApple
		batch.draw(texture,this.position.x,this.position.y);
	}
	
	public void setRight() {
		 	if(this.move) {
		 		this.position.x = this.position.x+SPEED;
		 	};
	}

	public void setLeft() {
		// TODO Auto-generated method stub
		if(this.move) {
	 		this.position.x = this.position.x-SPEED;
	 	};

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		this.dt = dt;
		this.TIMER-=dt;
		this.move = false;
	
		
	}

	@Override
	public void handlingInput() {
		
		
	}
	

}
