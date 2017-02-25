package com.libgdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.game.input.CutsceneInputProcessor;
import com.libgdx.game.state.StateEventEnum;
import com.libgdx.game.util.Timer;

public class CutsceneScreen extends Screen {

    private Stage stage;

	private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

	private Texture texture;
	private Image image;

	private Timer timer;
	private Float alpha;

    private CutsceneInputProcessor input;

    private boolean hasControllers = true;
	
	public CutsceneScreen() {
		super();
	}
	
	@Override
	public void create() {		
		batch = new SpriteBatch();
        camera = new OrthographicCamera(160, 144);
        camera.setToOrtho(false, 160, 144);
        viewport = new StretchViewport(160, 144, camera);

		texture = new Texture("splash.png");
		image = new Image(texture);

		timer = new Timer();
		alpha = 0f;

        stage = new Stage(viewport);
        stage.addActor(image);

        input = new CutsceneInputProcessor();
        input.initDependencies(getStateMachine());
        Gdx.input.setInputProcessor(input);

        if(Controllers.getControllers().size == 0) {
            hasControllers = false;
        }

		if (hasControllers) {
			Controllers.addListener(input);
		}

		Gdx.graphics.setWindowedMode(160*4, 144*4);
	}
	
	@Override
	public void update() {
		timer.update(Gdx.graphics.getDeltaTime());
		calculatesAlpha();		
		
		if(timer.getTime() > 4 && !timer.getExecuted()) {
			loadNextImage();
			timer.setExecuted(true);
		}
		
		if(timer.getTime() > 8) {
			changeState();
		}
	}

	private void calculatesAlpha() {
		float dt = Gdx.graphics.getDeltaTime();
		if(timer.getTime() < 1) alpha += dt;
		if(timer.getTime() > 1 && timer.getTime() < 3) alpha = 1f;
		if(timer.getTime() > 3 && timer.getTime() < 4) alpha -= dt;
		if(timer.getTime() > 4 && timer.getTime() < 5) alpha += dt;
		if(timer.getTime() > 5 && timer.getTime() < 7) alpha = 1f;
		if(timer.getTime() > 7) alpha -= dt;
	}

	private void loadNextImage() {
		texture = new Texture("lovesplashpixel.png");
		image = new Image(texture);
        stage.addActor(image);
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		batch.begin();
        image.draw(batch, alpha);
        batch.end();
	}
		
	private void changeState() {
		getStateMachine().handle(StateEventEnum.SPLASH_END);
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
}
