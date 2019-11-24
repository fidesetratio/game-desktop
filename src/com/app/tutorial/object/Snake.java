package com.app.tutorial.object;

import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Snake  extends GameObject {
	private boolean move;
	private static final float SNAKE_MOVEMENT = 32f;
	private float dt;
	private Apple apples[];
	private Monitor monitor;
	private static final float MOVE_TIME = 1f;
	private  float TIMER = MOVE_TIME;
	private int snakeDirection;
	public static final int RIGHT = 0;
	public static final int LEFT= 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	
	
	public Snake(float x, float y) {
		super();
		setPosition(x,y);
		init();
	}
	
	public Snake(float x, float y,Apple apple[]) {
		super();
		this.apples = apple;
		
		setPosition(x,y);
		init();
	}
	

	public Snake(float x, float y,Apple apple[],Monitor monitor) {
		super();
		this.apples = apple;
		this.monitor = monitor;
		setPosition(x,y);
		init();
	}

	private void setOverLapse() {
		if(apples != null) {
			boolean found = false;
			for(Apple a:apples) {
				if(this.overlaps(a)) {
					monitor.setText(a.getName());
					found = true;
				};
			}
			if(!found) {
				monitor.setText("");
			}
		}
	}

	
	private void checkForOutBounds() {
		// TODO Auto-generated method stub
			float x = position.x;
			float y = position.y;
			if(x>=Gdx.graphics.getWidth()) {
				position.x = position.x-SNAKE_MOVEMENT;
			}
			if(x<0) {
				position.x = position.x+SNAKE_MOVEMENT;
			}
			if(y >= Gdx.graphics.getHeight()) {
				position.y = position.y-SNAKE_MOVEMENT;
			}
			if(y < 0) {
				position.y = position.y+SNAKE_MOVEMENT;
			}
	}

	@Override
	public void update(float dt) {
		this.TIMER -= dt;
		 
		 this.handlingInput();
		  if(this.TIMER<=0) { 
			  	  setOverLapse();
			  	  checkForOutBounds();
				  this.moveSnake();
				  this.TIMER = MOVE_TIME; 
				  System.out.println(this.snakeDirection);
		  };
		 
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.texture = new Texture(Gdx.files.internal("resources/snake/snakehead.png"));
		bounds.setSize(this.texture.getWidth(), this.texture.getHeight());
		this.move =false;
		this.dt = 0f;
		this.snakeDirection = RIGHT;
	
	}

	@Override
	public void handlingInput() {
			  if(GameKeys.isPressed(GameKeys.RIGHT)){ setRight(); }else
			  if(GameKeys.isPressed(GameKeys.LEFT)) { setLeft(); }else
			  if(GameKeys.isPressed(GameKeys.UP)) { setTop(); }else
			  if(GameKeys.isPressed(GameKeys.DOWN)) { setBottom(); }
	
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		
		batch.draw(texture,this.position.x,this.position.y);

	}
	
	public void moveSnake() {
		switch(this.snakeDirection) {
		case RIGHT:
			{
				this.position.x += SNAKE_MOVEMENT;
			
				return;
			}
			
		case LEFT:{
			this.position.x -= SNAKE_MOVEMENT;
			return;
			
			
		}
		case UP:{
			this.position.y += SNAKE_MOVEMENT;
			return;
		}
		case DOWN:{
			this.position.y -= SNAKE_MOVEMENT;
			return;
		}
			
		}
	}

	
	public void setRight() {
	 	this.snakeDirection = RIGHT;
	}

public void setLeft() {
	this.snakeDirection = LEFT;
}
public void setTop() {
	this.snakeDirection = UP;
}

public void setBottom() {
	this.snakeDirection = DOWN;
}
}
