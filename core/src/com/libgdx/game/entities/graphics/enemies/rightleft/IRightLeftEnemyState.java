package com.libgdx.game.entities.graphics.enemies.rightleft;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.rightleft.RightLeftEnemy;

public interface IRightLeftEnemyState {

    void create();

    void update(float dt, RightLeftEnemy enemy);

    void draw(SpriteBatch batch, RightLeftEnemy enemy);

}
