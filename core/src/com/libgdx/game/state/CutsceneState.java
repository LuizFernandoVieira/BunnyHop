package com.libgdx.game.state;

import com.libgdx.game.screen.CutsceneScreen;

public class CutsceneState extends State {

	public void create(final StateMachine stateMachine) {
		setStateMachine(stateMachine);
		setScreen(new CutsceneScreen());
		getScreen().setStateMachine(stateMachine);
		getScreen().create();
	}

	@Override
	public void handle(StateEventEnum event) {
		if(event.equals(StateEventEnum.SPLASH_END)) {
			getStateMachine().changeState(new MenuState());
		}
	}
	
}
