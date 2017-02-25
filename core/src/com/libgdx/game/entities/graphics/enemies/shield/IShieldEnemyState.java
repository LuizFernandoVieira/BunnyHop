package com.libgdx.game.entities.graphics.enemies.shield;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.shield.ShieldEnemy;

public interface IShieldEnemyState {

    void create();

    void update(float dt, ShieldEnemy enemy);

    void draw(SpriteBatch batch, ShieldEnemy enemy);

}
