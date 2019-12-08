package com.app.game.snake2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Cell {
	

	private Vector2 position;
	public static final int HEAD = 0;
	public static final int BODY = 1;
	private int type;
	private Texture texture;
	private Rectangle bounds;
	
	public Cell(int type,float posx, float posy) {
		position = new Vector2(posx, posy);
		this.type = type;
		this.bounds = new Rectangle();
		this.bounds.setPosition(position);
	}
	public Cell(int type,Vector2 position) {
		this.position =position;
		this.type = type;
		this.bounds = new Rectangle();
		this.bounds.setPosition(position);
	}
	
	public void updatePosition(float nposx, float nposy) {
		this.position.x = nposx;
		this.position.y = nposy;
	}
	
	
	public boolean isHead() {
		return (this.type ==HEAD)?true:false;
	}
	public boolean isBody() {
		return (this.type ==BODY)?true:false;
	}
	public Texture getTexture() {
		if(this.type == HEAD)
		{
			this.texture = new Texture(Gdx.files.internal("resources/snake/snakehead.png"));
		}
		else if(this.type == BODY) {
			this.texture = new Texture(Gdx.files.internal("resources/snake/snakebody.png"));
		}
		
		return this.texture;
	}
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
}
