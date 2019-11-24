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
		this.move = true;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.texture = new Texture(Gdx.files.internal("resources/snake/snakehead.png"));
		bounds.setSize(this.texture.getWidth(), this.texture.getHeight());
		this.move =false;
		this.dt = 0f;
	
	}

	@Override
	public void handlingInput() {
		// TODO Auto-generated method stub
				if(GameKeys.isPressed(GameKeys.RIGHT)){
					setRight();
				}else if(GameKeys.isPressed(GameKeys.LEFT)) {
					setLeft();
				}else if(GameKeys.isPressed(GameKeys.UP)) {
					setTop();
				}else if(GameKeys.isPressed(GameKeys.DOWN)) {
					setBottom();
				}
		
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		setOverLapse();
		checkForOutBounds();
		batch.draw(texture,this.position.x,this.position.y);

	}

	
	public void setRight() {
	 	if(this.move) {
	 		this.position.x = this.position.x+SNAKE_MOVEMENT;
	 	};
	}

public void setLeft() {
	// TODO Auto-generated method stub
	if(this.move) {
 		this.position.x = this.position.x-SNAKE_MOVEMENT;
 	};

}
public void setTop() {
	// TODO Auto-generated method stub
	if(this.move) {
 		this.position.y = this.position.y+SNAKE_MOVEMENT;
 	};

}

public void setBottom() {
	// TODO Auto-generated method stub
	if(this.move) {
 		this.position.y = this.position.y-SNAKE_MOVEMENT;
 	};

}
}
