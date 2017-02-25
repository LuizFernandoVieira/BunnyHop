package com.libgdx.game.entities.beans.player;

public abstract class PlayerState {

    abstract void create();

    abstract void update(float dt, Player player);

}
