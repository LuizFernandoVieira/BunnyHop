package com.libgdx.game.entities.graphics.enemies.shoot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.shoot.ShootEnemy;

public class ShootEnemyGdx {

    private com.libgdx.game.entities.graphics.enemies.shoot.IdleShootEnemyState idleShootEnemyState;
    private com.libgdx.game.entities.graphics.enemies.shoot.WalkingShootEnemyState walkingShootEnemyState;

    private com.libgdx.game.entities.graphics.enemies.shoot.ShootEnemyTexture texture;
    private IShootEnemyState state;

    public ShootEnemyGdx() {
        idleShootEnemyState = new com.libgdx.game.entities.graphics.enemies.shoot.IdleShootEnemyState();
        walkingShootEnemyState = new com.libgdx.game.entities.graphics.enemies.shoot.WalkingShootEnemyState();
        state = idleShootEnemyState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new com.libgdx.game.entities.graphics.enemies.shoot.ShootEnemyTexture();
        idleShootEnemyState.setTexture(texture.getIdleTexture());
    }

    public void update(ShootEnemy enemy, float dt) {
        state.update(dt, enemy);
    }

    public void draw(SpriteBatch batch, ShootEnemy enemy) {
        state.draw(batch, enemy);
    }
}
