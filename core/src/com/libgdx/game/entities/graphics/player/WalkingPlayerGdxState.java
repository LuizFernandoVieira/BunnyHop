package com.libgdx.game.entities.graphics.player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.entities.beans.player.Player;

public class WalkingPlayerGdxState implements IPlayerState {

    private float stateTime;
    private TextureRegion[] textureRegionsFrames;
    private TextureRegion currentFrame;
    private Animation animation;

    @Override
    public void create() {
        animation = new Animation(0.1f, textureRegionsFrames);
        stateTime = 0;
    }

    @Override
    public void update(float dt, Player player) {
        stateTime += dt;
        currentFrame = (TextureRegion) animation.getKeyFrame(stateTime, true);
    }

    @Override
    public void draw(SpriteBatch batch, Player player) {
        batch.draw(
                currentFrame,
                player.getBox().getX(),
                player.getBox().getY(),
                player.getBox().getW(),
                player.getBox().getH()
        );
    }

    public TextureRegion[] getTextureRegionsFrames() {
        return textureRegionsFrames;
    }

    public void setTextureRegionsFrames(TextureRegion[] textureRegionsFrames) {
        this.textureRegionsFrames = textureRegionsFrames;
    }
}
