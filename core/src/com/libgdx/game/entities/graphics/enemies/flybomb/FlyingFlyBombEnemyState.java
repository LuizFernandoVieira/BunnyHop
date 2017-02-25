package com.libgdx.game.entities.graphics.enemies.flybomb;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.flybomb.FlyBombEnemy;

public class FlyingFlyBombEnemyState implements IFlyBombEnemyState {

    private Texture texture;

    @Override
    public void create() {

    }

    @Override
    public void update(float dt, FlyBombEnemy enemy) {

    }

    @Override
    public void draw(SpriteBatch batch, FlyBombEnemy enemy) {
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
