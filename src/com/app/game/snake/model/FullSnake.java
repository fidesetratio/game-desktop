package com.app.game.snake.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FullSnake {
		
		private Block head;
		private List<Block> snakes;
		
		private Texture headTexture;
		private static final int MAX_LENGTH = 2;
		private static final float BOX_WIDTH=32f;
		private float factorx = 0;
		private float factory = 0;
		
		
		private int direction;
		public FullSnake() {
				head = new Block(0, 100, 100);
				this.resetBody();
		}

		public void resetBody() {
			this.snakes = new ArrayList<Block>();
			this.factorx = 1;
			this.factory = 0;
			for(int i=0;i<MAX_LENGTH ;i++) {
				if(i==0) {
					this.snakes.add(this.head);
				}else {
					Block b = this.snakes.get(i-1);
					this.snakes.add(new Block(1, b.getPosition().x-(BOX_WIDTH*factorx), b.getPosition().y-(BOX_WIDTH*factory)));
				}
			}
			
		}
		
		public void draw(SpriteBatch sb) {
			for(int i = this.snakes.size();i>0;i--) {
				sb.draw(this.snakes.get(i-1).getTexture(),this.snakes.get(i-1).getPosition().x,this.snakes.get(i-1).getPosition().y);
			};
		}
}
