package com.app.game.snake2.model;

import java.util.ArrayList;
import java.util.List;

import com.app.game.tutorial.input.GameKeys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Snake2 {
	public static int MAX_FIRST_BODY = 6;
	private List<Cell> snakes;
	private static final float BOX_WIDTH = 32f;
	private static final float SNAKE_MOVEMENT = 32f;
	private float factorx = -1;
	private float factory = 0;
	private int direction;
	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	private Vector2 position;
	private Cell head;
	private boolean allowedGrowth = true;
	private Rectangle headRectangle;
	private Rectangle bodyReactangle;
	private Vector3 tmpCoords;
	private Vector2 tmpCoordsPos;
	private boolean allowedtomove;


	private OrthographicCamera cam;
	
	public Snake2() {
		this.createInitSnake();

	}

	public void createInitSnake() {
		this.headRectangle = new Rectangle();
		this.headRectangle.setWidth(BOX_WIDTH);
		this.headRectangle.setHeight(BOX_WIDTH);
		this.bodyReactangle = new Rectangle();
		this.bodyReactangle.setWidth(BOX_WIDTH);
		this.bodyReactangle.setHeight(BOX_WIDTH); 
		tmpCoords = new Vector3();
		tmpCoordsPos = new Vector2();
 
		this.allowedtomove = true;
		
		this.direction = LEFT;
		this.allowedGrowth = true;
		this.position = new Vector2(200, 200);
		this.snakes = new ArrayList<Cell>();
		for (int i = 0; i < MAX_FIRST_BODY; i++) {
			if (i == 0) {
				this.snakes.add(new Cell(Cell.HEAD, position.x,position.y));
			} else {
				Cell b = this.snakes.get(i - 1);
				this.snakes.add(new Cell(Cell.BODY, b.getPosition().x - (BOX_WIDTH * factorx),
						b.getPosition().y - (BOX_WIDTH * factory)));
			}
		}
		
	}

	public void draw(SpriteBatch sb) {
		for (int i = this.snakes.size(); i > 0; i--) {
			sb.draw(this.snakes.get(i - 1).getTexture(), this.snakes.get(i - 1).getPosition().x,
					this.snakes.get(i - 1).getPosition().y);
		}
		;
	}

	public void handlingInput() {
		// TODO Auto-generated method stub
		if (GameKeys.isPressed(GameKeys.RIGHT)) {
			this.allowedGrowth = true;
			direction = RIGHT;
		} else if (GameKeys.isPressed(GameKeys.LEFT)) {
			this.allowedGrowth = true;
			direction = LEFT;
		} else if (GameKeys.isPressed(GameKeys.UP)) {
			this.allowedGrowth = true;
			direction = UP;
		} else if (GameKeys.isPressed(GameKeys.DOWN)) {
			direction = DOWN;
			this.grow();
		}
		
		tmpCoords.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		cam.unproject(tmpCoords);
		tmpCoordsPos.set(tmpCoords.x, tmpCoords.y);
		
	}
	
	public void grow() {
		if(this.snakes.size()>0 && allowedGrowth == true) {
			int last = this.snakes.size() -1;
			Cell b = this.snakes.get(last);
			this.snakes.add(new Cell(Cell.BODY, b.getPosition().x - (BOX_WIDTH * factorx),
					b.getPosition().y - (BOX_WIDTH * factory)));
			allowedGrowth = false;
		}
	}
	
	
	

	public void move() {
		
		if(allowedtomove) {
		switch (this.direction) {
		case Snake2.LEFT:
			this.position.x -= SNAKE_MOVEMENT;
			break;
		case Snake2.RIGHT:
			this.position.x += SNAKE_MOVEMENT;
			break;
		case Snake2.UP:
			this.position.y += SNAKE_MOVEMENT;
			break;
		case Snake2.DOWN:
			this.position.y -= SNAKE_MOVEMENT;
			break;
		}
		this.moveBody();
		this.checkCrashWithBody();

		}
		this.checkWithCursor();	
	}
	
	public void checkWithCursor() {
		for(int i=0;i<this.snakes.size();i++) {
			Cell cell = this.snakes.get(i);
			this.bodyReactangle.setPosition(cell.getPosition());
			if(this.bodyReactangle.contains(tmpCoordsPos) && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				System.out.println("matikan perjalanan");
				if(!allowedtomove) {
					allowedtomove = true;
					break;
				}
				
				if(allowedtomove) {
					allowedtomove = false;
					break;
				}
				
			}
			
		}
		
	}

	
	public void checkCrashWithBody() {
		this.headRectangle.setPosition(this.position);
		for(int i=1;i<this.snakes.size();i++) {
			Cell cell = this.snakes.get(i);
			this.bodyReactangle.setPosition(cell.getPosition());
			if(this.headRectangle.overlaps(this.bodyReactangle)) {
				System.out.println("matiii luu");
				return;
			}
		}
	}
	
	private void moveBody() {
		int size = this.snakes.size();
		for (int i = size - 1; i >= 0; i--) {
			if(i==0) {
				this.snakes.get(i).updatePosition(this.position.x, this.position.y);
			}else {
				this.snakes.get(i).updatePosition(this.snakes.get(i-1).getPosition().x, this.snakes.get(i-1).getPosition().y);
			}
		}
	
	}
	
	public OrthographicCamera getCam() {
		return cam;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}
}
