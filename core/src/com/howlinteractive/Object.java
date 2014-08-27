package com.howlinteractive;

import com.badlogic.gdx.graphics.Texture;

public class Object extends Physical {
	
	@Override
	Type getType() { return Type.HAZARD; }
	
	static int WIDTH;
	static int HEIGHT;
	static void setSize() {
		WIDTH = Game.enemyImg.getWidth();
		HEIGHT = Game.enemyImg.getHeight();
	}
	
	Object(int x, int y, Texture img) {
		super(x, y, WIDTH, HEIGHT, img);
	}
	
	Object(int x, int y) {
		super(x, y, WIDTH, HEIGHT, Game.enemyImg);
	}
	
	@Override
	void handleCollisions(int dir) {
		super.handleCollisions(dir);
		if(collidingWith(Type.PLAYER)) {
			Game.gameOver();
		}
	}
}