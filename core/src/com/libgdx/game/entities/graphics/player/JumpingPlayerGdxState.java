package com.libgdx.game.entities.graphics.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.player.Player;

public class JumpingPlayerGdxState implements IPlayerState {

    private Texture texture;

    @Override
    public void create() {

    }

    @Override
    public void update(float dt, Player player) {

    }

    @Override
    public void draw(SpriteBatch batch, Player player) {
        if(texture != null) {
            batch.draw(
                    texture,
                    player.getBox().getX(),
                    player.getBox().getY(),
                    player.getBox().getW(),
                    player.getBox().getH()
            );
        }
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

}
