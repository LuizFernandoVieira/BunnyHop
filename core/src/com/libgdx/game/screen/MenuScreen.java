package com.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
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
import com.libgdx.game.input.MenuInputProcessor;
import com.libgdx.game.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuScreen extends Screen {

    private Stage stage;

	private SpriteBatch batch;	
	private OrthographicCamera camera;
	private Viewport viewport;

    MenuInputProcessor input;

	private Texture backgroundTexture;
	private Image backgroundImage;

    private Table table;

    Image arrowPlayImage;
    Image arrowOptionsImage;
    Image arrowExitImage;

    private int selected;

    private List<Image> menuImages;

    private boolean hasControllers = true;

	public MenuScreen() {
		super();
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
        camera = new OrthographicCamera(160, 144);
        camera.setToOrtho(false, 160, 144);
        viewport = new StretchViewport(160, 144, camera);

        backgroundTexture = new Texture(Gdx.files.internal("logogame.png"));
		backgroundImage = new Image(backgroundTexture);

        table = new Table();
        table.setWidth(Constants.CAMERA_WIDTH);
        table.setHeight(Constants.CAMERA_HEIGHT);
        table.center().center();

        selected = 1;

        getSkin().getFont("default-font").getData().setScale(0.25f, 0.25f);

        Texture arrowTexture = new Texture(Gdx.files.internal("gui/arrow.png"));

        arrowPlayImage = new Image(arrowTexture);
        arrowOptionsImage = new Image(arrowTexture);
        arrowExitImage = new Image(arrowTexture);

        arrowOptionsImage.setVisible(false);
        arrowExitImage.setVisible(false);

        menuImages = new ArrayList<Image>();
        menuImages.add(arrowPlayImage);
        menuImages.add(arrowOptionsImage);
        menuImages.add(arrowExitImage);

        table.add(arrowPlayImage).padTop(60).padBottom(2).padRight(2);
        Label btnPlay = new Label("PLAY", getSkin());
        table.add(btnPlay).width(40).height(10).padTop(60).padBottom(2).colspan(2);
        table.row();

        table.add(arrowOptionsImage).padBottom(2).padRight(2);
        Label btnOptions = new Label("OPTIONS", getSkin());
        table.add(btnOptions).width(40).height(10).padBottom(2).colspan(2);
        table.row();

        table.add(arrowExitImage).padRight(2);
        Label btnExit = new Label("EXIT", getSkin());
        table.add(btnExit).width(40).height(10).colspan(2);

        stage = new Stage(viewport);
        stage.addActor(backgroundImage);
        stage.addActor(table);

        input = new MenuInputProcessor(getStateMachine(), this);

        if(Controllers.getControllers().size == 0) {
            hasControllers = false;
        }

        if (hasControllers) {
            Controllers.addListener(input);
        }

        Gdx.input.setInputProcessor(input);
    }
	
	@Override
	public void draw() {		
	    Gdx.gl.glClearColor(0, 0, 0, 1);
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

    public Image getArrowPlayImage() {
        return arrowPlayImage;
    }

    public Image getArrowExitImage() {
        return arrowExitImage;
    }

    public Image getArrowOptionsImage() {
        return arrowOptionsImage;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public List<Image> getMenuImages() {
        return menuImages;
    }
}
