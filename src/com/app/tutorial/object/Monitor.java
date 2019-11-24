package com.app.tutorial.object;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Monitor   extends GameObject {
	
	
	private BitmapFont bitmapFont;
	private String text;
	
	
	
	public Monitor(float x, float y) {
		super();
		setPosition(x,y);
		init();
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void handlingInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		bitmapFont.draw(batch, this.text, position.x,position.y);
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.bitmapFont = new BitmapFont();
		this.setText("");
	}

}
