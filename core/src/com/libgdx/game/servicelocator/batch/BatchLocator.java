package com.libgdx.game.servicelocator.batch;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BatchLocator {

    private static SpriteBatch service;

    public static void provide(SpriteBatch batch) {
        service = batch;
    }

    public static SpriteBatch getBatch() {
        return service;
    }

}
