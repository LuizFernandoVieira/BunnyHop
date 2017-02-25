package com.libgdx.game.entities.graphics.enemies.blob;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.enemies.blob.BlobEnemy;

public class BlobEnemyGdx {

    private BlobTexture texture;

    public BlobEnemyGdx() {
        texture = new BlobTexture();
    }

    public void update(BlobEnemy blob, float dt) {

    }

    public void draw(SpriteBatch batch, BlobEnemy blob) {
        batch.draw(
            texture.getTexture(),
            blob.getBox().getX(),
            blob.getBox().getY(),
            blob.getBox().getW(),
            blob.getBox().getH()
        );
    }

}
