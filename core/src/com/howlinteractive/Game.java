package com.howlinteractive;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	
	enum State { MENU, PLAYING, PAUSED, GAME_OVER }
	static State state;

	static Random rand = new Random();
	
	static SpriteBatch sB;
	
	static int width;
	static int height;
	
	static Level level;

	static Texture rect;
	static Texture playerImg;
	static Texture enemyImg;
	static Texture tileImg;
	static Texture wallImg;
	static Texture itemImg;
	
	@Override
	public void create () {
		sB = new SpriteBatch();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		loadTextures();
		setSizes();
		level = new Level(new Player(100, 10, playerImg), 0, -1);
		level.objs.add(new Object(100, 300, enemyImg));
		state = State.PLAYING;
	}
	
	void reset() {
		level = new Level(new Player(100, 10, playerImg), 0, -1);
		level.objs.add(new Object(100, 300, enemyImg));
	}
	
	void loadTextures() {
		playerImg = new Texture("badlogic.jpg");
		enemyImg = new Texture("badlogic.jpg");
		tileImg = new Texture("badlogic.jpg");
		wallImg = new Texture("badlogic.jpg");
		itemImg = new Texture("badlogic.jpg");
		rect = new Texture("rect.png");
	}
	
	void setSizes() {
		Tile.setSize();
		Player.setSize();
		Wall.setSize();
		Object.setSize();
	}
	
	void handleInput() {
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			level.onTouch();
		}
	}

	void update() {
		switch(state) {
		case PLAYING:
			level.update();
			break;
		case GAME_OVER:
			state = State.PLAYING;
			reset();
			break;
		case MENU:
			break;
		case PAUSED:
			break;
		default:
			break;
		}
	}
	
	void draw() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sB.begin();
		level.draw();
		sB.end();
	}
	
	@Override
	public void render () {
		handleInput();
		update();
		draw();
	}
	
	static int getXInput() {
		return Gdx.input.getX();
	}
	
	static int getYInput() {
		return Game.height - Gdx.input.getY();
	}
	
	static void gameOver() {
		state = State.GAME_OVER;
	}
}