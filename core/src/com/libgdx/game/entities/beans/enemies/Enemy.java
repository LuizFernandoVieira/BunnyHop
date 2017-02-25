package com.libgdx.game.entities.beans.enemies;

import com.libgdx.game.entities.beans.GameObject;

public abstract class Enemy extends GameObject {

    private boolean facingRight;
    private boolean grounded;

    private int health;

    private float xSpeed;
    private float ySpeed;

    public Enemy() {
        super();
        initEnemy();
    }

    public Enemy(int x, int y) {
        super(x, y);
        initEnemy();
    }

    public Enemy(int x, int y, int w, int h) {
        super(x, y, w, h);
        initEnemy();
    }

    private void initEnemy() {
        facingRight = false;
        grounded = false;
        health = 10;
        xSpeed = 0;
        ySpeed = 0;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void isDead() {

    }

    @Override
    public void notifyCollision(GameObject other) {

    }
}
