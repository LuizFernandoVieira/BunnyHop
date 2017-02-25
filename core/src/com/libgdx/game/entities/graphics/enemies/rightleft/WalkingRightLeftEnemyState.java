package com.libgdx.game.entities.graphics.enemies.rightleft;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.rightleft.RightLeftEnemy;

public class WalkingRightLeftEnemyState implements IRightLeftEnemyState {

    private Texture texture;

    @Override
    public void create() {

    }

    @Override
    public void update(float dt, RightLeftEnemy enemy) {

    }

    @Override
    public void draw(SpriteBatch batch, RightLeftEnemy enemy) {
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
