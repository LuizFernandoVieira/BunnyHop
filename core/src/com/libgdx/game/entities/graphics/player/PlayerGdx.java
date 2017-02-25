package com.libgdx.game.entities.graphics.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.player.Player;

public class PlayerGdx {

    private IdlePlayerGdxState idlePlayerGdxState;
    private WalkingPlayerGdxState walkingPlayerGdxState;
    private JumpingPlayerGdxState jumpingPlayerGdxState;
    private FallingPlayerGdxState fallingPlayerGdxState;
    private DyingPlayerGdxState dyingPlayerGdxState;

    private IdleInfectedPlayerGdxState idleInfectedPlayerGdxState;
    private WalkingInfectedPlayerGdxState walkingInfectedPlayerGdxState;
    private JumpingInfectedPlayerGdxState jumpingInfectedPlayerGdxState;
    private FallingPlayerInfectedGdxState fallingPlayerInfectedGdxState;
    private DyingInfectedPlayerGdxState dyingInfectedPlayerGdxState;

    private PlayerTexture texture;
    private IPlayerState state;

    public PlayerGdx() {
        idlePlayerGdxState = new IdlePlayerGdxState();
        walkingPlayerGdxState = new WalkingPlayerGdxState();
        jumpingPlayerGdxState = new JumpingPlayerGdxState();
        fallingPlayerGdxState = new FallingPlayerGdxState();
        dyingPlayerGdxState = new DyingPlayerGdxState();
        idleInfectedPlayerGdxState = new IdleInfectedPlayerGdxState();
        walkingInfectedPlayerGdxState = new WalkingInfectedPlayerGdxState();
        jumpingInfectedPlayerGdxState = new JumpingInfectedPlayerGdxState();
        fallingPlayerInfectedGdxState = new FallingPlayerInfectedGdxState();
        dyingInfectedPlayerGdxState = new DyingInfectedPlayerGdxState();
        state = walkingPlayerGdxState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new PlayerTexture();
        idlePlayerGdxState.setTexture(texture.getIdle());
        walkingPlayerGdxState.setTextureRegionsFrames(texture.getWalking());
        jumpingPlayerGdxState.setTexture(texture.getJumping());
        fallingPlayerGdxState.setTexture(texture.getFallingInfected());
        dyingPlayerGdxState.setTexture(texture.getDying());
        idleInfectedPlayerGdxState.setTexture(texture.getIdleInfected());
        walkingInfectedPlayerGdxState.setTextureRegionsFrames(texture.getWalkingInfected());
        jumpingInfectedPlayerGdxState.setTexture(texture.getJumpingInfected());
        fallingPlayerInfectedGdxState.setTexture(texture.getFallingInfected());
        dyingInfectedPlayerGdxState.setTexture(texture.getDyingInfected());
        callStatesCreation();
    }

    private void callStatesCreation() {
        idlePlayerGdxState.create();
        walkingPlayerGdxState.create();
        jumpingPlayerGdxState.create();
        fallingPlayerGdxState.create();
        dyingPlayerGdxState.create();
        idleInfectedPlayerGdxState.create();
        walkingInfectedPlayerGdxState.create();
        jumpingInfectedPlayerGdxState.create();
        fallingPlayerInfectedGdxState.create();
        dyingInfectedPlayerGdxState.create();
    }

    public void update(Player player, float dt) {
        state.update(dt, player);
    }

    public void draw(SpriteBatch batch, Player player) {
        state.draw(batch, player);
    }

    public IdlePlayerGdxState getIdlePlayerGdxState() {
        return idlePlayerGdxState;
    }

    public void setIdlePlayerGdxState(IdlePlayerGdxState idlePlayerGdxState) {
        this.idlePlayerGdxState = idlePlayerGdxState;
    }

    public WalkingPlayerGdxState getWalkingPlayerGdxState() {
        return walkingPlayerGdxState;
    }

    public void setWalkingPlayerGdxState(WalkingPlayerGdxState walkingPlayerGdxState) {
        this.walkingPlayerGdxState = walkingPlayerGdxState;
    }

    public JumpingPlayerGdxState getJumpingPlayerGdxState() {
        return jumpingPlayerGdxState;
    }

    public void setJumpingPlayerGdxState(JumpingPlayerGdxState jumpingPlayerGdxState) {
        this.jumpingPlayerGdxState = jumpingPlayerGdxState;
    }

    public FallingPlayerGdxState getFallingPlayerGdxState() {
        return fallingPlayerGdxState;
    }

    public void setFallingPlayerGdxState(FallingPlayerGdxState fallingPlayerGdxState) {
        this.fallingPlayerGdxState = fallingPlayerGdxState;
    }

    public DyingPlayerGdxState getDyingPlayerGdxState() {
        return dyingPlayerGdxState;
    }

    public void setDyingPlayerGdxState(DyingPlayerGdxState dyingPlayerGdxState) {
        this.dyingPlayerGdxState = dyingPlayerGdxState;
    }

    public IdleInfectedPlayerGdxState getIdleInfectedPlayerGdxState() {
        return idleInfectedPlayerGdxState;
    }

    public void setIdleInfectedPlayerGdxState(IdleInfectedPlayerGdxState idleInfectedPlayerGdxState) {
        this.idleInfectedPlayerGdxState = idleInfectedPlayerGdxState;
    }

    public WalkingInfectedPlayerGdxState getWalkingInfectedPlayerGdxState() {
        return walkingInfectedPlayerGdxState;
    }

    public void setWalkingInfectedPlayerGdxState(WalkingInfectedPlayerGdxState walkingInfectedPlayerGdxState) {
        this.walkingInfectedPlayerGdxState = walkingInfectedPlayerGdxState;
    }

    public JumpingInfectedPlayerGdxState getJumpingInfectedPlayerGdxState() {
        return jumpingInfectedPlayerGdxState;
    }

    public void setJumpingInfectedPlayerGdxState(JumpingInfectedPlayerGdxState jumpingInfectedPlayerGdxState) {
        this.jumpingInfectedPlayerGdxState = jumpingInfectedPlayerGdxState;
    }

    public FallingPlayerInfectedGdxState getFallingPlayerInfectedGdxState() {
        return fallingPlayerInfectedGdxState;
    }

    public void setFallingPlayerInfectedGdxState(FallingPlayerInfectedGdxState fallingPlayerInfectedGdxState) {
        this.fallingPlayerInfectedGdxState = fallingPlayerInfectedGdxState;
    }

    public DyingInfectedPlayerGdxState getDyingInfectedPlayerGdxState() {
        return dyingInfectedPlayerGdxState;
    }

    public void setDyingInfectedPlayerGdxState(DyingInfectedPlayerGdxState dyingInfectedPlayerGdxState) {
        this.dyingInfectedPlayerGdxState = dyingInfectedPlayerGdxState;
    }

    public PlayerTexture getTexture() {
        return texture;
    }

    public void setTexture(PlayerTexture texture) {
        this.texture = texture;
    }

    public IPlayerState getState() {
        return state;
    }

    public void setState(IPlayerState state) {
        this.state = state;
    }
}
