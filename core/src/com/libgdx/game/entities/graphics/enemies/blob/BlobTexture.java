package com.libgdx.game.entities.graphics.enemies.blob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlobTexture {

    private Texture texture;

    public BlobTexture() {
        texture = new Texture(Gdx.files.internal("entities/enemies/blob/driper_down.png"));
    }

    public Texture getTexture() {
        return texture;
    }

}
