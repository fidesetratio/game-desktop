package com.app.game.snake2;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class BigSnakeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	      config.title = "Snake";
	      config.width = 800;
	      config.height = 480;
	      new LwjglApplication(new BigSnake(), config);
	}

}
