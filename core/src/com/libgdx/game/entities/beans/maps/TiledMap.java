package com.libgdx.game.entities.beans.maps;

import com.libgdx.game.entities.graphics.maps.TiledMapGdx;
import com.libgdx.game.servicelocator.camera.CameraLocator;

public class TiledMap extends Map {

    private TiledMapGdx tiledMapGdx;

    public TiledMap() {
        tiledMapGdx = new TiledMapGdx();
    }

    public void update() {
        tiledMapGdx.update();
    }

    public void draw() {
        tiledMapGdx.draw(CameraLocator.getCamera());
    }

}
