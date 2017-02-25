package com.libgdx.game.state;

import com.libgdx.game.screen.GameScreen;

public class GameState extends State {

    public void create(final StateMachine stateMachine) {
        setStateMachine(stateMachine);
        setScreen(new GameScreen());
        getScreen().setStateMachine(stateMachine);
        getScreen().create();
    }

    @Override
    public void handle(StateEventEnum event) {

    }
}
