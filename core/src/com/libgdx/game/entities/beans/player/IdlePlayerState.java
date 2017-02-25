package com.libgdx.game.entities.beans.player;

public class IdlePlayerState extends PlayerState {

    @Override
    void create() {

    }

    @Override
    void update(float dt, Player player) {
        if(player.isMoveRight()) {
//            int vel = Collision.handleCollision(self.box.x, self.box.y, self.velocity, dt);
//            player.getBox().setX(player.getBox().getX() + vel);
            player.setState(new WalkingPlayerState());
            player.getPlayerGdx().setState(player.getPlayerGdx().getWalkingPlayerGdxState());
        }
    }

}
