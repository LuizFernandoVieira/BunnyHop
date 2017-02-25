package com.libgdx.game.state;

import com.libgdx.game.screen.OptionsScreen;

public class OptionsState extends State {

    public void create(final StateMachine stateMachine) {
        setStateMachine(stateMachine);
        setScreen(new OptionsScreen());
        getScreen().setStateMachine(stateMachine);
        getScreen().create();
    }

    @Override
    public void handle(StateEventEnum event) {

    }
}
