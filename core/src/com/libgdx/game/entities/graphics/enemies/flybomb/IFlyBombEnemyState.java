package com.libgdx.game.entities.graphics.enemies.flybomb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.flybomb.FlyBombEnemy;

public interface IFlyBombEnemyState {

    void create();

    void update(float dt, FlyBombEnemy enemy);

    void draw(SpriteBatch batch, FlyBombEnemy enemy);

}
