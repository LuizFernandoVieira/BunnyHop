package com.libgdx.game.entities.graphics.enemies.flybomb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.flybomb.FlyBombEnemy;

public class FlyBombEnemyGdx {

    private IdleFlyBombEnemyState idleFlyBombEnemyState;
    private com.libgdx.game.entities.graphics.enemies.flybomb.FlyingFlyBombEnemyState flyingFlyBombEnemyState;

    private FlyBombEnemyTexture texture;
    private IFlyBombEnemyState state;

    public FlyBombEnemyGdx() {
        idleFlyBombEnemyState = new IdleFlyBombEnemyState();
        flyingFlyBombEnemyState = new com.libgdx.game.entities.graphics.enemies.flybomb.FlyingFlyBombEnemyState();
        state = idleFlyBombEnemyState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new FlyBombEnemyTexture();
        idleFlyBombEnemyState.setTexture(texture.getIdleTexture());
    }

    public void update(FlyBombEnemy enemy, float dt) {
        state.update(dt, enemy);
    }

    public void draw(SpriteBatch batch, FlyBombEnemy enemy) {
        state.draw(batch, enemy);
    }

}
