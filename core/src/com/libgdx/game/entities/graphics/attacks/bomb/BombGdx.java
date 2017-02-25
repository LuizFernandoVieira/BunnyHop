package com.libgdx.game.entities.graphics.attacks.bomb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.attacks.Bomb;

public class BombGdx {

    private BombTexture texture;

    public BombGdx() {
        texture = new BombTexture();
    }

    public void update(Bomb bomb, float dt) {

    }

    public void draw(SpriteBatch batch, Bomb bomb) {
        batch.draw(texture.getTexture(), bomb.getBox().getX(), bomb.getBox().getY(),
                bomb.getBox().getW(), bomb.getBox().getH());
    }

}
