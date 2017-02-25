package com.libgdx.game.entities.graphics.enemies.shield;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class ShieldEnemyTexture {

    private Texture idleTexture;
    private Texture defTexture;

    private TextureRegion[] def;

    public ShieldEnemyTexture() {
        idleTexture = new Texture(Gdx.files.internal("entities/enemies/shield/shield_idle.png"));
        defTexture = new Texture(Gdx.files.internal("entities/enemies/shield/shield_def.png"));

        def = new TextureRegion[Constants.SHIELD_DEF_ENEMY_FRAME_COUNT];

        for(int i=0; i< Constants.SHIELD_DEF_ENEMY_FRAME_COUNT ; i++) {
            def[i] = new TextureRegion(defTexture, i * Constants.SHIELD_DEF_ENEMY_WIDTH,
                    0, Constants.SHIELD_DEF_ENEMY_WIDTH, Constants.SHIELD_DEF_ENEMY_HEIGHT);
        }
    }

    public Texture getIdleTexture() {
        return idleTexture;
    }

    public void setIdleTexture(Texture idleTexture) {
        this.idleTexture = idleTexture;
    }

    public Texture getDefTexture() {
        return defTexture;
    }

    public void setDefTexture(Texture defTexture) {
        this.defTexture = defTexture;
    }

    public TextureRegion[] getDef() {
        return def;
    }

    public void setDef(TextureRegion[] def) {
        this.def = def;
    }

}
