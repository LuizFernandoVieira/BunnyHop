package com.libgdx.game.entities.graphics.enemies.defshot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.defshot.DefShotEnemy;

public class AttackingDefShotEnemyState implements IDefShotEnemyState {

    private Texture texture;

    @Override
    public void create() {

    }

    @Override
    public void update(float dt, DefShotEnemy enemy) {

    }

    @Override
    public void draw(SpriteBatch batch, DefShotEnemy enemy) {
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
