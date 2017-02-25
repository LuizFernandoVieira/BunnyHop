package com.libgdx.game.entities.graphics.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.player.Player;

public interface IPlayerState {

	void create();
	
	void update(float dt, Player player);
	
	void draw(SpriteBatch batch, Player player);
	
}
