package com.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.libgdx.game.state.StateMachine;

public abstract class Screen {

	private Skin skin;
	private StateMachine stateMachine;

	public Screen() {
		FileHandle handle = Gdx.files.internal("uiskin.json");
		this.skin = new Skin(handle);
	}

	public abstract void create();

	public void update() {
	}

	public void draw() {

	}

	public void dispose() {

	}

	public void resize(int width, int height) {

	}


	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public StateMachine getStateMachine() {
		return stateMachine;
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

}
