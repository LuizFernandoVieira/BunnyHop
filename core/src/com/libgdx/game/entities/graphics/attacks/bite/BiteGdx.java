package com.libgdx.game.entities.graphics.attacks.bite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.game.entities.beans.attacks.Bite;

public class BiteGdx {

    private BiteTexture texture;

    public void initGraphics() {
        texture = new BiteTexture();
    }

    public void draw(SpriteBatch batch, Bite bite) {
//        batch.draw(texture, bite.getBox().getX() - (bite.getBox().getW() / 2),
//                bite.getBox().getY() - (bite.getBox().getH() / 2), bite.getBox().getW(),
//                bite.getBox().getH());
    }

}
