package com.howlinteractive;

import com.badlogic.gdx.graphics.Texture;

public class Tile extends Physical {

	@Override
	Type getType() { return Type.NONE; }
	
	static int SIZE;
	static void setSize() {
		SIZE = 50;
	}
	
	int row, col;
	
	Tile(int row, int col, Texture img) {
		super(col * SIZE, row * SIZE, SIZE, SIZE, img);
		this.row = row;
		this.col = col;
	}
	
	Tile(int row, int col) {
		super(col * SIZE, row * SIZE, SIZE, SIZE, Game.tileImg);
		this.row = row;
		this.col = col;
	}
}