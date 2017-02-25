package com.libgdx.game.entities.beans.attacks;

import com.libgdx.game.entities.beans.GameObject;
import com.libgdx.game.entities.graphics.attacks.bite.BiteGdx;

public class Bite extends GameObject {

    private boolean facingRight;
    private float lifeTime;
    private BiteGdx biteGdx;

    public Bite() {
        facingRight = true;
        lifeTime = 0.45f;
        biteGdx = new BiteGdx();
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void draw() {
//        biteGdx.draw();
    }

    @Override
    public void isDead() {

    }

    @Override
    public void notifyCollision(GameObject other) {

    }
}
