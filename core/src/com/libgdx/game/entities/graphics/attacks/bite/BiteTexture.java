package com.libgdx.game.entities.graphics.attacks.bite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.game.util.Constants;

public class BiteTexture {

    private Texture texture;
    private TextureRegion[] frames;

    public BiteTexture() {
        texture = new Texture(Gdx.files.internal(""));

        for(int i=0; i< Constants.PLAYER_WALKING_FRAME_COUNT ; i++) {
            frames[i] = new TextureRegion(texture, i * Constants.BITE_WIDTH,
                    0, Constants.BITE_WIDTH, Constants.BITE_HEIGHT);
        }
    }



}
