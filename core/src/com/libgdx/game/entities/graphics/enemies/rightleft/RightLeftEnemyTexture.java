package com.libgdx.game.entities.graphics.enemies.rightleft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class RightLeftEnemyTexture {

    private Texture idleTexture;
    private Texture walkingTexture;

    private TextureRegion[] idle;
    private TextureRegion[] walking;

    public RightLeftEnemyTexture() {
        idleTexture = new Texture(Gdx.files.internal("entities/enemies/rightleft/bear_cat.png"));
        walkingTexture = new Texture(Gdx.files.internal("entities/enemies/rightleft/bear_cat.png"));

        idle = new TextureRegion[Constants.RIGHT_LEFT_IDLE_ENEMY_FRAME_COUNT];
        walking = new TextureRegion[Constants.RIGHT_LEFT_WALKING_ENEMY_FRAME_COUNT];

        for(int i=0; i< Constants.RIGHT_LEFT_IDLE_ENEMY_FRAME_COUNT ; i++) {
            idle[i] = new TextureRegion(idleTexture, i * Constants.RIGHT_LEFT_IDLE_ENEMY_WIDTH,
                    0, Constants.RIGHT_LEFT_IDLE_ENEMY_WIDTH, Constants.RIGHT_LEFT_IDLE_ENEMY_HEIGHT);
        }

        for(int i=0; i< Constants.RIGHT_LEFT_WALKING_ENEMY_FRAME_COUNT ; i++) {
            walking[i] = new TextureRegion(walkingTexture, i * Constants.RIGHT_LEFT_WALKING_ENEMY_WIDTH,
                    0, Constants.RIGHT_LEFT_WALKING_ENEMY_WIDTH, Constants.RIGHT_LEFT_WALKING_ENEMY_HEIGHT);
        }
    }

    public Texture getIdleTexture() {
        return idleTexture;
    }

    public void setIdleTexture(Texture idleTexture) {
        this.idleTexture = idleTexture;
    }

    public Texture getWalkingTexture() {
        return walkingTexture;
    }

    public void setWalkingTexture(Texture walkingTexture) {
        this.walkingTexture = walkingTexture;
    }

    public TextureRegion[] getIdle() {
        return idle;
    }

    public void setIdle(TextureRegion[] idle) {
        this.idle = idle;
    }

    public TextureRegion[] getWalking() {
        return walking;
    }

    public void setWalking(TextureRegion[] walking) {
        this.walking = walking;
    }

}
