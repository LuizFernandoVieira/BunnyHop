package com.libgdx.game.entities.graphics.enemies.shoot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.shoot.ShootEnemy;

public interface IShootEnemyState {

    void create();

    void update(float dt, ShootEnemy enemy);

    void draw(SpriteBatch batch, ShootEnemy enemy);

}
