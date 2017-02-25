package com.libgdx.game.geometry;

public class Rect {
	
	private int x;
	private int y;
	private int w;
	private int h;

	public Rect(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = 0;
		this.h = 0;
	}
	
	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public Point center() {
		Point point = new Point(x + w/2, y + h/2);
		return point;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}	

}
