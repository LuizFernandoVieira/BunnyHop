package com.libgdx.game.entities.graphics.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class PlayerTexture {

    private Texture idle;
    private Texture jumping;
    private Texture falling;
    private Texture dying;

    private Texture idleInfected;
    private Texture jumpingInfected;
    private Texture fallingInfected;
    private Texture dyingInfected;

    private Texture walkingTexture;
    private Texture walkingInfectedTexture;

    private TextureRegion[] walking;
    private TextureRegion[] walkingInfected;

    public PlayerTexture() {
        idle = new Texture(Gdx.files.internal("entities/player/player_idle.png"));
        jumping = new Texture(Gdx.files.internal("entities/player/player_jumping.png"));
        falling = new Texture(Gdx.files.internal("entities/player/player_jumping.png"));
        dying = new Texture(Gdx.files.internal("entities/player/player_idle.png"));

        idleInfected = new Texture(Gdx.files.internal("entities/player/player_infected_idle.png"));
        jumpingInfected = new Texture(Gdx.files.internal("entities/player/player_infected_jumping.png"));
        fallingInfected = new Texture(Gdx.files.internal("entities/player/player_infected_jumping.png"));
        dyingInfected = new Texture(Gdx.files.internal("entities/player/player_infected_dying.png"));

        walkingTexture = new Texture(Gdx.files.internal("entities/player/player_walking.png"));
        walkingInfectedTexture = new Texture(Gdx.files.internal("entities/player/player_infected_walking.png"));

        walking = new TextureRegion[Constants.PLAYER_WALKING_FRAME_COUNT];
        walkingInfected = new TextureRegion[Constants.PLAYER_WALKING_INFECTED_FRAME_COUNT];

        for(int i=0; i< Constants.PLAYER_WALKING_FRAME_COUNT ; i++) {
            walking[i] = new TextureRegion(walkingTexture,
                    i * (Constants.PLAYER_WALKING_WIDTH / Constants.PLAYER_WALKING_FRAME_COUNT),
                    0, (Constants.PLAYER_WALKING_WIDTH / Constants.PLAYER_WALKING_FRAME_COUNT),
                    Constants.PLAYER_WALKING_HEIGHT);
        }

        for(int i=0; i< Constants.PLAYER_WALKING_INFECTED_FRAME_COUNT ; i++) {
            walkingInfected[i] = new TextureRegion(walkingInfectedTexture,
                    i * (Constants.PLAYER_WALKING_INFECTED_WIDTH / Constants.PLAYER_WALKING_INFECTED_FRAME_COUNT),
                    0, (Constants.PLAYER_WALKING_INFECTED_WIDTH / Constants.PLAYER_WALKING_INFECTED_FRAME_COUNT),
                    Constants.PLAYER_WALKING_INFECTED_HEIGHT);
        }

    }

    public Texture getIdle() {
        return idle;
    }

    public Texture getJumping() {
        return jumping;
    }

    public Texture getFalling() {
        return falling;
    }

    public Texture getDying() {
        return dying;
    }

    public Texture getIdleInfected() {
        return idleInfected;
    }

    public Texture getJumpingInfected() {
        return jumpingInfected;
    }

    public Texture getFallingInfected() {
        return fallingInfected;
    }

    public Texture getDyingInfected() {
        return dyingInfected;
    }

    public Texture getWalkingTexture() {
        return walkingTexture;
    }

    public Texture getWalkingInfectedTexture() {
        return walkingInfectedTexture;
    }

    public TextureRegion[] getWalking() {
        return walking;
    }

    public TextureRegion[] getWalkingInfected() {
        return walkingInfected;
    }
}
