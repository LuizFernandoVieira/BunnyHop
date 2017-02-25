package com.libgdx.game.entities.beans.player;

import com.libgdx.game.entities.beans.GameObject;
import com.libgdx.game.entities.graphics.player.PlayerGdx;
import com.libgdx.game.enums.PlayerWeapon;
import com.libgdx.game.servicelocator.batch.BatchLocator;
import com.libgdx.game.util.Timer;

public class Player extends GameObject {

    private boolean moveRight;
    private boolean moveLeft;
    private boolean facingRight;
    private boolean grounded;
    private boolean canClimb;
    private boolean infected;
    private boolean blinkAfterHit;

    private int health;

    private float velocity;
    private float xSpeed;
    private float ySpeed;
    private float dashDuration;
    private float dashCooldown;
    private float bulletAmount;
    private float shotgunCooldown;
    private float dmgCooldown;
    private float respawnTime;

    private Timer blinkTime;
    private PlayerWeapon playerWeapon;
    private PlayerState state;
    private PlayerGdx playerGdx;

    public Player() {
        super(16, 32, 16, 24);
        moveRight = false;
        moveLeft = false;
        facingRight = true;
        grounded = false;
        canClimb = false;
        infected = false;
        blinkAfterHit = false;
        health = 3;
        velocity = 1;
        xSpeed = 0;
        ySpeed = 0;
        dashDuration = 0;
        dashCooldown = 0;
        bulletAmount = 50;
        shotgunCooldown = 0;
        dmgCooldown = 0;
        respawnTime = 5;
        blinkTime = new Timer();
        playerWeapon = PlayerWeapon.GUN;
        state = new IdlePlayerState();
        playerGdx = new PlayerGdx();
    }

    @Override
    public void update(float dt) {
        int lastX = getBox().getX();
        int lastY = getBox().getY();

        state.update(dt, this);
        playerGdx.update(this, dt);
    }

    @Override
    public void draw() {
        playerGdx.draw(BatchLocator.getBatch(), this);
    }

    @Override
    public void isDead() {

    }

    @Override
    public void notifyCollision(GameObject other) {

    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    public PlayerGdx getPlayerGdx() {
        return playerGdx;
    }

    public void setPlayerGdx(PlayerGdx playerGdx) {
        this.playerGdx = playerGdx;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }
}
