package com.app.tutorial.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	



	protected Rectangle bounds;
	protected Vector2 position;
	protected Texture texture;

	
	public GameObject() {
		position = new Vector2();
		bounds = new Rectangle();
	}
	
	public abstract void handlingInput();
	public abstract void draw(SpriteBatch batch);
	public abstract void update(float dt);
	public abstract void init();
	
	
	public void setPosition(float x, float y) {
		this.position = new Vector2(x, y);
	}
	
	public boolean overlaps(GameObject others) {
		return this.getBounds().overlaps(others.getBounds());
	}
	public Rectangle getBounds() {
		bounds.setPosition(this.position.x, this.position.y);
		return bounds;
	}

	public Rectangle getRectangle() {
		return this.bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}




	public Vector2 getPosition() {
		return position;
	}




	public void setPosition(Vector2 position) {
		this.position = position;
	}
	


}
