package com.app.game.tutorial;

import com.app.HelloGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class TutorialGame {

		public TutorialGame() {
			  LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		      config.title = "Drop";
		      config.width = 800;
		      config.height = 480;
		      new LwjglApplication(new Tutorial(), config);
		  
		}
}
