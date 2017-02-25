package com.libgdx.game.entities.graphics.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledMapGdx {

    private TiledMap tiledMap;
    private TmxMapLoader tiledLoader;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMapTileLayer foreground;

    public TiledMapGdx() {
        tiledLoader = new TmxMapLoader();
        tiledMap = tiledLoader.load("map/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap, 1);
        foreground = (TiledMapTileLayer) tiledMap.getLayers().get("foreground");
    }

    public void update() {
    }

    public void draw(OrthographicCamera camera) {
        renderer.setView(camera);
        renderer.render();
    }

    public TiledMapTileLayer getForeground() {
        return foreground;
    }

    public void setForeground(TiledMapTileLayer foreground) {
        this.foreground = foreground;
    }

}
