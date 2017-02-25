package com.libgdx.game.entities.graphics.enemies.shield;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.shield.ShieldEnemy;

public class IdleShieldEnemyState implements IShieldEnemyState {

    private Texture texture;

    @Override
    public void create() {

    }

    @Override
    public void update(float dt, ShieldEnemy enemy) {

    }

    @Override
    public void draw(SpriteBatch batch, ShieldEnemy enemy) {
        if(texture != null) {
            batch.draw(
                texture,
                enemy.getBox().getX(),
                enemy.getBox().getY(),
                enemy.getBox().getW(),
                enemy.getBox().getH()
            );
        }
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

}
