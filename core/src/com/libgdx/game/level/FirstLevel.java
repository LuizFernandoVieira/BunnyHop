package com.libgdx.game.level;

import com.libgdx.game.entities.beans.player.Player;

public class FirstLevel implements Level {

    private Player player;

    public FirstLevel() {
        player = new Player();
    }

    @Override
    public void update(float dt) {
        player.update(dt);
    }

    @Override
    public void draw() {
        player.draw();
    }

}
