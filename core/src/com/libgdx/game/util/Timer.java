package com.libgdx.game.util;

public class Timer {

	private float time;
	private boolean executed;
	
	public Timer() {
		time = 0.0f;
		executed = false;
	}
	
	public void update(float dt) {
		time += dt;
	}
	
	public void restart() {
		time = 0.0f;
	}
	
	public float getTime() {
		return time;
	}
	
	public boolean getExecuted() {
		return executed;
	}
	
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
}
