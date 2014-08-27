package com.howlinteractive;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public abstract class Physical {

	enum Type { NONE, PLAYER, WALL, HAZARD, ITEM }
	abstract Type getType();
	ArrayList<Physical> collisions;
	boolean collidingWith(Type type) {
		for(Physical obj : collisions) {
			if(obj.getType() == type) {
				return true;
			}
		}
		return false;
	}
	int indexOfCollision(Type type) {
		for(int i = 0; i < collisions.size(); i++) {
			if(collisions.get(i).getType() == type) {
				return i;
			}
		}
		return -1;
	}
	Physical collision(Type type) {
		return collisions.get(indexOfCollision(type));
	}
	
	int x;
	int y;
	int w;
	int h;
	
	float xVel;
	float yVel;
	
	Texture img;

	boolean isAlive = true;
	
	Physical(int x, int y, int w, int h, Texture img) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.img = img;
	}
	
	boolean isCollidingWith(Physical obj) {
		return x + w > obj.x && x < obj.x + obj.w && y + h > obj.y && y < obj.y + obj.h;
	}

	boolean isColliding() {
		collisions = new ArrayList<Physical>();
		for(int i = 0; i < Game.level.objs.size(); i++) {
			if(this != Game.level.objs.get(i) && isCollidingWith(Game.level.objs.get(i))) {
				collisions.add(Game.level.objs.get(i));
			}
		}
		return collisions.size() != 0;
	}
	
	void handleCollisions(int dir) {
		if(collidingWith(Type.WALL)) {
			if(dir == 0) {
				x -= Math.signum(xVel);
				xVel = 0;
			}
			else if(dir == 1) {
				y -= Math.signum(yVel);
				yVel = 0;
			}
		}
	}
	
	void update() {
		if(isColliding()) {
			handleCollisions(-1);
		}
		for(int i = 0; i < Math.abs(Math.round(xVel)); i++) {
			x += Math.signum(xVel);
			if(isColliding()) {
				handleCollisions(0);
			}
		}
		for(int i = 0; i < Math.abs(Math.round(yVel)); i++) {
			y += Math.signum(yVel);
			if(isColliding()) {
				handleCollisions(1);
			}
		}
	}
	
	void draw() {
		Game.sB.draw(img, x, y, w, h);
	}
}