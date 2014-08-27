package com.howlinteractive;

import com.badlogic.gdx.graphics.Texture;

public class Item extends Physical {

	@Override
	Type getType() { return Type.ITEM; }
	
	static int WIDTH;
	static int HEIGHT;
	static void setSize() {
		WIDTH = Game.itemImg.getWidth();
		HEIGHT = Game.itemImg.getHeight();
	}
	
	Item(int x, int y, Texture img) {
		super(x, y, WIDTH, HEIGHT, img);
	}
	
	Item(int x, int y) {
		super(x, y, WIDTH, HEIGHT, Game.itemImg);
	}
	
	@Override
	void handleCollisions(int dir) {
		super.handleCollisions(dir);
		if(collisions.contains(Type.PLAYER)) {
			Game.level.p.pickup(this);
		}
	}
}