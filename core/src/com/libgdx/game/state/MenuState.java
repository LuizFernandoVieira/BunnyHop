package com.libgdx.game.state;

import com.libgdx.game.screen.MenuScreen;

public class MenuState extends State {

	public void create(final StateMachine stateMachine) {
		setStateMachine(stateMachine);
		setScreen(new MenuScreen());
		getScreen().setStateMachine(stateMachine);
		getScreen().create();
	}

	@Override
	public void handle(StateEventEnum event) {
		
	}
	
}
