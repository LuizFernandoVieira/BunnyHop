package com.libgdx.game.entities.graphics.enemies.flybomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class FlyBombEnemyTexture {

    private Texture idleTexture;
    private Texture flyingTexture;

    private TextureRegion[] idle;
    private TextureRegion[] flying;

    public FlyBombEnemyTexture() {
        idleTexture = new Texture(Gdx.files.internal("entities/enemies/flybomb/flybomb.png"));
        flyingTexture = new Texture(Gdx.files.internal("entities/enemies/flybomb/flybomb.png"));

        idle = new TextureRegion[Constants.FLY_BOMB_ENEMY_FLYING_FRAME_COUNT];

        for(int i=0; i< Constants.FLY_BOMB_ENEMY_FLYING_FRAME_COUNT ; i++) {
            idle[i] = new TextureRegion(idleTexture, i * Constants.FLY_BOMB_ENEMY_FLYING_WIDTH,
                    0, Constants.FLY_BOMB_ENEMY_FLYING_WIDTH, Constants.FLY_BOMB_ENEMY_FLYING_HEIGHT);
        }

        for(int i=0; i< Constants.FLY_BOMB_ENEMY_FLYING_FRAME_COUNT ; i++) {
            flying[i] = new TextureRegion(flyingTexture, i * Constants.FLY_BOMB_ENEMY_FLYING_WIDTH,
                    0, Constants.FLY_BOMB_ENEMY_FLYING_WIDTH, Constants.FLY_BOMB_ENEMY_FLYING_HEIGHT);
        }
    }

    public Texture getIdleTexture() {
        return idleTexture;
    }

    public void setIdleTexture(Texture idleTexture) {
        this.idleTexture = idleTexture;
    }

    public Texture getFlyingTexture() {
        return flyingTexture;
    }

    public void setFlyingTexture(Texture flyingTexture) {
        this.flyingTexture = flyingTexture;
    }

    public TextureRegion[] getIdle() {
        return idle;
    }

    public void setIdle(TextureRegion[] idle) {
        this.idle = idle;
    }

    public TextureRegion[] getFlying() {
        return flying;
    }

    public void setFlying(TextureRegion[] flying) {
        this.flying = flying;
    }

}
