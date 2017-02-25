package com.libgdx.game.state;

public class StateMachine {
	
	private IState state = new CutsceneState();
	
	public void create() {
		state.create(this);
	}
	
	public void update() {
		state.update();
	}
	
	public void draw() {
		state.draw();
	}
	
	public void dispose() {
		state.dispose();
	}
	
	public void changeState(IState state) {
		this.state.dispose();
		this.state = state;
		this.state.create(this);
	}
	
	public void handle(StateEventEnum event) {
		this.state.handle(event);
	}

	public void resize(int width, int height) {
		this.state.resize(width, height);
	}
	
	public IState getState() {
		return state;
	}
	
	public void setState(IState state) {
		this.state = state;
	}
	
}
