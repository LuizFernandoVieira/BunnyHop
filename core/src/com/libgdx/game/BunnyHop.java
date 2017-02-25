package com.libgdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.libgdx.game.state.StateMachine;

public class BunnyHop extends ApplicationAdapter {
	
	private StateMachine stateMachine;
	
	@Override
	public void create() {
		stateMachine = new StateMachine();
		stateMachine.create();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateMachine.update();
		stateMachine.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		stateMachine.resize(width, height);
	}
}
