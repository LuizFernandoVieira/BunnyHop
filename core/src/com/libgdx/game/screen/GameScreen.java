package com.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.game.entities.beans.maps.EngineMap;
import com.libgdx.game.entities.beans.maps.Map;
import com.libgdx.game.input.GameInputProcessor;
import com.libgdx.game.level.FirstLevel;
import com.libgdx.game.servicelocator.batch.BatchLocator;
import com.libgdx.game.servicelocator.camera.CameraLocator;
import com.libgdx.game.servicelocator.stage.StageLocator;

public class GameScreen extends Screen {

    private Stage stage;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Map map;
    private FirstLevel firstLevel;

    public GameScreen() {
        super();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        BatchLocator.provide(batch);
        camera = new OrthographicCamera(160, 144);
        CameraLocator.provide(camera);
        camera.setToOrtho(false, 160, 144);
        viewport = new StretchViewport(160, 144, camera);

        stage = new Stage(viewport);
        StageLocator.provide(stage);

        map = new EngineMap();
        firstLevel = new FirstLevel();

        GameInputProcessor input = new GameInputProcessor();
    }

    @Override
    public void update() {
        map.update();
        firstLevel.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void draw() {
        Color bg = new Color();
        bg = bg.valueOf("#E6D69C");
        Gdx.gl.glClearColor(bg.r, bg.g, bg.b, bg.a);

        viewport.apply();
        stage.draw();

        map.draw();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        firstLevel.draw();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

}
