package com.howlinteractive;

import com.badlogic.gdx.graphics.Texture;

public class Wall extends Physical {

	@Override
	Type getType() { return Type.WALL; }
	
	static int WIDTH;
	static int HEIGHT;
	static void setSize() {
		WIDTH = Game.wallImg.getWidth();
		HEIGHT = Game.wallImg.getHeight();
	}

	Wall(int x, int y, Texture img) {
		super(x, y, WIDTH, HEIGHT, img);
	}

	Wall(int x, int y) {
		super(x, y, WIDTH, HEIGHT, Game.wallImg);
	}
	
	Wall(int x, int y, int w, int h) {
		super(x, y, w, h, Game.rect);
	}
}
