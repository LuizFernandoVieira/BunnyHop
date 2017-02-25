package com.libgdx.game.entities.graphics.enemies.spike;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.attacks.Bomb;
import com.libgdx.game.entities.beans.enemies.spike.SpikeEnemy;

public class SpikeEnemyGdx {

    private SpikeEnemyTexture texture;

    public SpikeEnemyGdx() {
        texture = new SpikeEnemyTexture();
    }

    public void update(Bomb bomb, float dt) {

    }

    public void draw(SpriteBatch batch, SpikeEnemy enemy) {
        batch.draw(
            texture.getTexture(),
            enemy.getBox().getX(),
            enemy.getBox().getY(),
            enemy.getBox().getW(),
            enemy.getBox().getH()
        );
    }

}
