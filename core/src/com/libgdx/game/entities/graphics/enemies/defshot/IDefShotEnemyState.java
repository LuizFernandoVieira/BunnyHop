package com.libgdx.game.entities.graphics.enemies.defshot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.defshot.DefShotEnemy;

public interface IDefShotEnemyState {

    void create();

    void update(float dt, DefShotEnemy enemy);

    void draw(SpriteBatch batch, DefShotEnemy enemy);

}
