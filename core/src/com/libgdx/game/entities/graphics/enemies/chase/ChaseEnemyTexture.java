package com.libgdx.game.entities.graphics.enemies.chase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class ChaseEnemyTexture {

    private Texture idleTexture;
    private Texture walkingTexture;

    private TextureRegion[] idle;
    private TextureRegion[] walking;

    public ChaseEnemyTexture() {
        idleTexture = new Texture(Gdx.files.internal("entities/enemies/chase/chase.png"));
        walkingTexture = new Texture(Gdx.files.internal("entities/enemies/chase/chase.png"));

        idle = new TextureRegion[Constants.CHASE_ENEMY_WALKING_FRAME_COUNT];
        walking = new TextureRegion[Constants.CHASE_ENEMY_WALKING_FRAME_COUNT];

        for(int i=0; i< Constants.PLAYER_WALKING_FRAME_COUNT ; i++) {
            idle[i] = new TextureRegion(idleTexture, i * Constants.CHASE_ENEMY_WALKING_WIDTH,
                    0, Constants.CHASE_ENEMY_WALKING_WIDTH, Constants.CHASE_ENEMY_WALKING_HEIGHT);
        }

        for(int i=0; i< Constants.PLAYER_WALKING_INFECTED_FRAME_COUNT ; i++) {
            walking[i] = new TextureRegion(walkingTexture, i * Constants.CHASE_ENEMY_WALKING_WIDTH,
                    0, Constants.CHASE_ENEMY_WALKING_WIDTH, Constants.CHASE_ENEMY_WALKING_HEIGHT);
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
