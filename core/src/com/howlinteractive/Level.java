package com.howlinteractive;

import java.util.ArrayList;

public class Level {

	ArrayList<Physical> objs;
	
	Player p;
	
	boolean scrolling;
	float xScroll;
	float yScroll;

	Level() {
		objs = new ArrayList<Physical>();
	}
	
	Level(Player p) {
		objs = new ArrayList<Physical>();
		objs.add(this.p = p);
	}
	
	Level(float xScroll, float yScroll) {
		objs = new ArrayList<Physical>();
		
		scrolling = true;
		this.xScroll = xScroll;
		this.yScroll = yScroll;
	}
	
	Level(Player p, float xScroll, float yScroll) {
		objs = new ArrayList<Physical>();
		objs.add(this.p = p);
		
		scrolling = true;
		this.xScroll = xScroll;
		this.yScroll = yScroll;
	}
	
	void draw() {
		for(Physical obj : objs) {
			obj.draw();
		}
	}
	
	void update() {
		createObjects();
		for(Physical obj : objs) {
			obj.update();
		}
		
		for(int i = objs.size() - 1; i >= 0; i--) {
			if(!objs.get(i).isAlive) {
				objs.remove(i);
			}
		}
		scroll();
	}
	
	void createObjects() {
		
	}
	
	void scroll() {
		if(xScroll != 0) {
			float tempX = p.xVel;
			p.xVel = -xScroll;
			p.update();
			p.xVel = tempX;
			for(Physical obj : objs) {
				obj.x += xScroll;
			}
		}
		if(yScroll != 0) {
			float tempY = p.yVel;
			p.yVel = -yScroll;
			p.update();
			p.yVel = tempY;
			for(Physical obj : objs) {
				obj.y += yScroll;
			}
		}
	}

	void onTouch() {
		
	}
}
