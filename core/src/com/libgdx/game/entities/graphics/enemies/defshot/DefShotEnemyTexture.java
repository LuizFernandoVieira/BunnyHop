package com.libgdx.game.entities.graphics.enemies.defshot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class DefShotEnemyTexture {

    private Texture hidingTexture;
    private Texture attackingTexture;

    private TextureRegion[] attacking;

    public DefShotEnemyTexture() {
        hidingTexture = new Texture(Gdx.files.internal("entities/enemies/defshot/defshot_idle.png"));
        attackingTexture = new Texture(Gdx.files.internal("entities/enemies/defshot/defshot_attacking"));

        attacking = new TextureRegion[Constants.DEF_SHOT_ENEMY_ATTACKING_FRAME_COUNT];

        for(int i=0; i< Constants.DEF_SHOT_ENEMY_ATTACKING_FRAME_COUNT ; i++) {
            attacking[i] = new TextureRegion(attackingTexture, i * Constants.DEF_SHOT_ENEMY_ATTACKING_WIDTH,
                    0, Constants.DEF_SHOT_ENEMY_ATTACKING_WIDTH, Constants.DEF_SHOT_ENEMY_ATTACKING_HEIGHT);
        }
    }

    public Texture getHidingTexture() {
        return hidingTexture;
    }

    public void setHidingTexture(Texture hidingTexture) {
        this.hidingTexture = hidingTexture;
    }

    public Texture getAttackingTexture() {
        return attackingTexture;
    }

    public void setAttackingTexture(Texture attackingTexture) {
        this.attackingTexture = attackingTexture;
    }

    public TextureRegion[] getAttacking() {
        return attacking;
    }

    public void setAttacking(TextureRegion[] attacking) {
        this.attacking = attacking;
    }

}
