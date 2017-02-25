package com.libgdx.game.entities.graphics.enemies.chase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.chase.ChaseEnemy;

public class ChaseEnemyGdx {

    private com.libgdx.game.entities.graphics.enemies.chase.IdleChaseEnemyState idleChaseEnemyState;
    private com.libgdx.game.entities.graphics.enemies.chase.WalkingChaseEnemyState walkingChaseEnemyState;

    private com.libgdx.game.entities.graphics.enemies.chase.ChaseEnemyTexture texture;
    private IChaseEnemyState state;

    public ChaseEnemyGdx() {
        idleChaseEnemyState = new com.libgdx.game.entities.graphics.enemies.chase.IdleChaseEnemyState();
        walkingChaseEnemyState = new com.libgdx.game.entities.graphics.enemies.chase.WalkingChaseEnemyState();
        state = idleChaseEnemyState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new com.libgdx.game.entities.graphics.enemies.chase.ChaseEnemyTexture();
        idleChaseEnemyState.setTexture(texture.getIdleTexture());
    }

    public void update(ChaseEnemy enemy, float dt) {
        state.update(dt, enemy);
    }

    public void draw(SpriteBatch batch, ChaseEnemy enemy) {
        state.draw(batch, enemy);
    }

}
