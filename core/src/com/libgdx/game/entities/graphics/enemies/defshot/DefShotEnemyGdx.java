package com.libgdx.game.entities.graphics.enemies.defshot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.defshot.DefShotEnemy;

public class DefShotEnemyGdx {

    private HidingDefShotEnemyState hidingDefShotEnemyState;
    private com.libgdx.game.entities.graphics.enemies.defshot.AttackingDefShotEnemyState attackingDefShotEnemyState;

    private com.libgdx.game.entities.graphics.enemies.defshot.DefShotEnemyTexture texture;
    private IDefShotEnemyState state;

    public DefShotEnemyGdx() {
        hidingDefShotEnemyState = new HidingDefShotEnemyState();
        attackingDefShotEnemyState = new com.libgdx.game.entities.graphics.enemies.defshot.AttackingDefShotEnemyState();
        state = hidingDefShotEnemyState;
        initGraphics();
    }

    private void initGraphics() {
        texture = new com.libgdx.game.entities.graphics.enemies.defshot.DefShotEnemyTexture();
        hidingDefShotEnemyState.setTexture(texture.getHidingTexture());
    }

    public void update(DefShotEnemy enemy, float dt) {
        state.update(dt, enemy);
    }

    public void draw(SpriteBatch batch, DefShotEnemy enemy) {
        state.draw(batch, enemy);
    }

}
