package com.app.game.snake.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Block {
		private Vector2 position;
		public static final int HEAD = 0;
		public static final int BODY = 1;
		private int type;
		private Texture texture;
		public Block() {
			position = new Vector2(0, 0);
			this.type = HEAD;
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
		
		public Block(int type, float x, float y) {
			position = new Vector2(0, 0);
			this.type = type;
			this.position.x = x;
			this.position.y = y;
		}
		
		public void updatePosition(float x, float y) {
			position.x = x;
			position.y = y;
		}
		public Vector2 getPosition() {
			return position;
		}
		public void setPosition(Vector2 position) {
			this.position = position;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}
}
