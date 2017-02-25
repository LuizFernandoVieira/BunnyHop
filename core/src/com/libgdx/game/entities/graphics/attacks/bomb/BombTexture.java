package com.libgdx.game.entities.graphics.attacks.bomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BombTexture {

    private Texture texture;

    public BombTexture() {
        texture = new Texture(Gdx.files.internal("entities/bomb/bomb.png"));
    }

    public Texture getTexture() {
        return texture;
    }

}
