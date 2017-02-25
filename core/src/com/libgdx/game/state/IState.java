package com.libgdx.game.state;

public interface IState {

	void create(StateMachine stateMachine);
	
	void update();
	
	void draw();
	
	void dispose();
	
	void handle(StateEventEnum event);
	
	void resize(int width, int height);
	
}
