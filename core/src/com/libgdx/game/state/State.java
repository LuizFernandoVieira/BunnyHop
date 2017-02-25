package com.libgdx.game.state;

import com.libgdx.game.screen.Screen;

public abstract class State implements IState {

	private Screen screen;
	private StateMachine stateMachine;

	@Override
	public void create(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
		screen.create();
	}
	
	@Override
	public void update() {
		screen.update();
	}
	
	@Override
	public void draw() {
		screen.draw();
	}
	
	@Override
	public void dispose() {
		screen.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		screen.resize(width, height);
	}
	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public StateMachine getStateMachine() {
		return stateMachine;
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

}
