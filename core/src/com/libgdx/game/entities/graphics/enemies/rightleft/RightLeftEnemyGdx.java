package com.libgdx.game.entities.graphics.enemies.rightleft;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.rightleft.RightLeftEnemy;

public class RightLeftEnemyGdx {

    private IdleRightLeftEnemyState idleRightLeftEnemyState;
    private WalkingRightLeftEnemyState walkingRightLeftEnemyState;

    private RightLeftEnemyTexture texture;
    private IRightLeftEnemyState state;

    public RightLeftEnemyGdx() {
        idleRightLeftEnemyState = new IdleRightLeftEnemyState();
        walkingRightLeftEnemyState = new WalkingRightLeftEnemyState();
        state = idleRightLeftEnemyState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new RightLeftEnemyTexture();
        idleRightLeftEnemyState.setTexture(texture.getIdleTexture());
    }

    public void update(RightLeftEnemy enemy, float dt) {
        state.update(dt, enemy);
    }

    public void draw(SpriteBatch batch, RightLeftEnemy enemy) {
        state.draw(batch, enemy);
    }

}
