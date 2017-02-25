package com.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.game.input.OptionsInputProcessor;
import com.libgdx.game.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class OptionsScreen extends Screen {

    private Stage stage;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    private OptionsInputProcessor input;
    private boolean hasControllers = true;

    private Table table;

    private int selected;

    private List<Image> optionsImages;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(160, 144);
        camera.setToOrtho(false, 160, 144);
        viewport = new StretchViewport(160, 144, camera);

        table = new Table();
        table.setWidth(Constants.CAMERA_WIDTH);
        table.setHeight(Constants.CAMERA_HEIGHT);
        table.center().left().padLeft(Constants.CAMERA_WIDTH/4);

        selected = 1;

        Texture arrowTexture = new Texture(Gdx.files.internal("gui/arrow.png"));
        Image arrowScaleImage = new Image(arrowTexture);
        Image arrowFullscreenImage = new Image(arrowTexture);
        Image arrowVsyncImage = new Image(arrowTexture);
        Image arrowSoundVol = new Image(arrowTexture);
        Image arrowMusicVol = new Image(arrowTexture);
        Image arrowBack = new Image(arrowTexture);

        arrowFullscreenImage.setVisible(false);
        arrowVsyncImage.setVisible(false);
        arrowSoundVol.setVisible(false);
        arrowMusicVol.setVisible(false);
        arrowBack.setVisible(false);

        optionsImages = new ArrayList<Image>();
        optionsImages.add(arrowScaleImage);
        optionsImages.add(arrowFullscreenImage);
        optionsImages.add(arrowVsyncImage);
        optionsImages.add(arrowSoundVol);
        optionsImages.add(arrowMusicVol);
        optionsImages.add(arrowBack);

        getSkin().getFont("default-font").getData().setScale(0.25f, 0.25f);

        table.add(arrowScaleImage).padBottom(2).padRight(2);
        Label lbScale = new Label("SCALE", getSkin());
        table.add(lbScale).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        table.add(arrowFullscreenImage).padBottom(2).padRight(2);
        Label lbFullScreen = new Label("FULLSCREEN", getSkin());
        table.add(lbFullScreen).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        table.add(arrowVsyncImage).padBottom(2).padRight(2);
        Label lbVsync = new Label("VSYNC", getSkin());
        table.add(lbVsync).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        table.add(arrowSoundVol).padBottom(2).padRight(2);
        Label lbSoundVol = new Label("SOUND VOL", getSkin());
        table.add(lbSoundVol).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        table.add(arrowMusicVol).padBottom(2).padRight(2);
        Label lbMusicVol = new Label("MUSIC VOL", getSkin());
        table.add(lbMusicVol).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        table.add(arrowBack).padBottom(2).padRight(2);
        Label lbBack = new Label("BACK", getSkin());
        table.add(lbBack).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        stage = new Stage(viewport);
        stage.addActor(table);

        input = new OptionsInputProcessor(getStateMachine(), this);
        Gdx.input.setInputProcessor(input);

        if(Controllers.getControllers().size == 0) {
            hasControllers = false;
        }

        if (hasControllers) {
            Controllers.addListener(input);
        }
    }

    @Override
    public void draw() {
        Color bg = new Color();
        bg = bg.valueOf("#E6D69C");
        Gdx.gl.glClearColor(bg.r, bg.g, bg.b, bg.a);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public List<Image> getOptionsImages() {
        return optionsImages;
    }
}
