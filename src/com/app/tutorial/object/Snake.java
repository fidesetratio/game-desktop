package com.app.tutorial.object;

import java.util.ArrayList;

import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

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
	private Array<SnakeBody> snakeBodies;
	protected Vector2 positiontemp;
	
	
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
				if(this.overlaps(a) && a.isAppleVisible()) {
					monitor.setText(a.getName());
					found = true;
					a.setAppleVisible(false);
					SnakeBody sb = new SnakeBody();
					sb.setPosition(positiontemp.x,positiontemp.y);
					snakeBodies.insert(0, sb);
					System.out.println("nambah pae apa nihh"+sb.getPosition().x);
				};
			}
			if(!found) {
				monitor.setText("");
			}
		}
	}

	
	@Override
	public boolean overlaps(GameObject others) {
		// TODO Auto-generated method stub
		
		return super.overlaps(others);
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
				  this.updateBodyPart();
				  this.TIMER = MOVE_TIME; 
		  };
		 
	}

	private void updateBodyPart() {
		// TODO Auto-generated method stub
		if(snakeBodies.size>0) {
			SnakeBody b = snakeBodies.removeIndex(0);
			b.setPosition(this.positiontemp.x,this.positiontemp.y);
			snakeBodies.add(b);
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.texture = new Texture(Gdx.files.internal("resources/snake/snakehead.png"));
		bounds.setSize(this.texture.getWidth(), this.texture.getHeight());
		this.move =false;
		this.dt = 0f;
		this.snakeDirection = RIGHT;
		this.snakeBodies = new Array<Snake.SnakeBody>();
		this.positiontemp = new Vector2(0, 0);
	
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
		System.out.println("currentConddition:"+this.position.x);
		for(SnakeBody snakeBody :this.snakeBodies) {
			if(!this.position.equals(snakeBody.getPosition())) {
				//System.out.println("sama terus nih..");
				batch.draw(snakeBody.getTexture(),snakeBody.getPosition().x,snakeBody.getPosition().y);
				
			}

			
		}

	}
	
	public void moveSnake() {

		this.positiontemp = this.position;
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

	private class SnakeBody{
		
		

			protected Vector2 position;
			public Texture getTexture() {
				return texture;
			}
			
			

			public void setTexture(Texture texture) {
				this.texture = texture;
			}

			protected Texture texture;
			
			public SnakeBody(Texture texture) {
				this.texture = texture;
			}
			
			public SnakeBody() {
				this.texture = new Texture(Gdx.files.internal("resources/snake/snakebody.png"));
			}
			
			public Vector2 getPosition() {
				return position;
			}

			public void setPosition(float x, float y) {
				this.position = new Vector2(x, y);
			}
			public void setPosition(Vector2 position) {
				this.position = position;
			}
	}
}
