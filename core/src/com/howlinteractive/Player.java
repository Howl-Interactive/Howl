package com.howlinteractive;

import com.badlogic.gdx.graphics.Texture;

public class Player extends Physical {
	
	@Override
	Type getType() { return Type.PLAYER; }

	static int WIDTH;
	static int HEIGHT;
	static void setSize() {
		WIDTH = Game.playerImg.getWidth();
		HEIGHT = Game.playerImg.getHeight();
	}
	
	Player(int x, int y, Texture img) {
		super(x, y, WIDTH, HEIGHT, img);
	}
	
	Player(int x, int y) {
		super(x, y, WIDTH, HEIGHT, Game.playerImg);
	}
	
	@Override
	void handleCollisions(int dir) {
		super.handleCollisions(dir);
		if(collidingWith(Type.HAZARD)) {
			Game.gameOver();
		}
		if(collidingWith(Type.ITEM)) {
			pickup((Item)collision(Type.ITEM));
		}
	}
	
	void pickup(Item item) {
		
	}
}