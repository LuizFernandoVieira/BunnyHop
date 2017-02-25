package com.libgdx.game.entities.graphics.enemies.shoot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class ShootEnemyTexture {

    private Texture idleTexture;
    private Texture walkingTexture;

    private TextureRegion[] walking;

    public ShootEnemyTexture() {
        idleTexture = new Texture(Gdx.files.internal("entities/enemies/shoot/shoot_idle.png"));
        walkingTexture = new Texture(Gdx.files.internal("entities/enemies/shoot/shoot_walking.png"));

        walking = new TextureRegion[Constants.SHOOT_WALKING_ENEMY_FRAME_COUNT];

        for(int i=0; i< Constants.SHOOT_WALKING_ENEMY_FRAME_COUNT ; i++) {
            walking[i] = new TextureRegion(walkingTexture, i * Constants.SHOOT_WALKING_ENEMY_WIDTH,
                    0, Constants.SHOOT_WALKING_ENEMY_WIDTH, Constants.SHOOT_WALKING_ENEMY_HEIGHT);
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

    public TextureRegion[] getWalking() {
        return walking;
    }

    public void setWalking(TextureRegion[] walking) {
        this.walking = walking;
    }

}
