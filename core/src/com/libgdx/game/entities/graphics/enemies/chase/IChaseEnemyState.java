package com.libgdx.game.entities.graphics.enemies.chase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.chase.ChaseEnemy;

public interface IChaseEnemyState {

    void create();

    void update(float dt, ChaseEnemy enemy);

    void draw(SpriteBatch batch, ChaseEnemy enemy);


}
