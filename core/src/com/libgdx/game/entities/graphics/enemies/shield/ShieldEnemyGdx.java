package com.libgdx.game.entities.graphics.enemies.shield;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.shield.ShieldEnemy;

public class ShieldEnemyGdx {

    private IdleShieldEnemyState idleShieldEnemyState;
    private DefShieldEnemyState defShieldEnemyState;

    private ShieldEnemyTexture texture;
    private IShieldEnemyState state;

    public ShieldEnemyGdx() {
        idleShieldEnemyState = new IdleShieldEnemyState();
        defShieldEnemyState = new DefShieldEnemyState();
        state = idleShieldEnemyState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new ShieldEnemyTexture();
        idleShieldEnemyState.setTexture(texture.getIdleTexture());
    }

    public void update(ShieldEnemy enemy, float dt) {
        state.update(dt, enemy);
    }

    public void draw(SpriteBatch batch, ShieldEnemy enemy) {
        state.draw(batch, enemy);
    }

}
