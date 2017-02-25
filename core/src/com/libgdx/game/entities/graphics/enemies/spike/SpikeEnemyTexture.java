package com.libgdx.game.entities.graphics.enemies.spike;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SpikeEnemyTexture {

    private Texture texture;

    public SpikeEnemyTexture() {
        texture = new Texture(Gdx.files.internal("entities/enemies/spike/spike.png"));
    }

    public Texture getTexture() {
        return texture;
    }

}
