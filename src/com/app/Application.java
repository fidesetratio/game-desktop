package com.app;

import com.app.game.tutorial.TutorialGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Application {
	public static void main (String[] arg) {
		/*
		 * LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		 * config.title = "Drop"; config.width = 800; config.height = 480; new
		 * LwjglApplication(new HelloGame(), config);
		 */ 
	
		new TutorialGame();
	}
}
