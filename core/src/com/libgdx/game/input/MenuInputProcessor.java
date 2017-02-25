package com.libgdx.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.libgdx.game.gamepad.XBox360GamePad;
import com.libgdx.game.screen.MenuScreen;
import com.libgdx.game.state.GameState;
import com.libgdx.game.state.OptionsState;
import com.libgdx.game.state.StateMachine;

import static com.libgdx.game.util.Util.wrap;

public class MenuInputProcessor implements InputProcessor, ControllerListener {

    private StateMachine stateMachine;
    private MenuScreen menuScreen;

    private boolean axisCanChange = true;

    public MenuInputProcessor(StateMachine stateMachine, MenuScreen menuScreen) {
        this.stateMachine = stateMachine;
        this.menuScreen = menuScreen;
    }

    @Override
    public void connected(Controller controller) {

    }

    @Override
    public void disconnected(Controller controller) {

    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        if(buttonCode == XBox360GamePad.BUTTON_A) {
            if(menuScreen.getSelected() == 1) {
                stateMachine.changeState(new GameState());
            } else if(menuScreen.getSelected() == 2) {
                stateMachine.changeState(new OptionsState());
            } else if(menuScreen.getSelected() == 3) {
                Gdx.app.exit();
            }
        }
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        int numberOfOptions = 3;

        if(axisCode == XBox360GamePad.AXIS_LEFT_Y) {
            if(value <= -0.99 && axisCanChange) {
                int s = wrap(menuScreen.getSelected() - 1, 1, numberOfOptions);
                menuScreen.setSelected(s);
                axisCanChange = false;
            }
            if(value >= 1 && axisCanChange) {
                int s = wrap(menuScreen.getSelected() + 1, 1, numberOfOptions);
                menuScreen.setSelected(s);
                axisCanChange = false;
            }
            if(value > -0.3 || value < 0.3) {
                axisCanChange = true;
            }
        }

        updateArrowVisibility();

        return false;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        System.out.println("POV MOVED");
        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {

        int numberOfOptions = 3;

        if(keycode == Input.Keys.W) {
            menuScreen.setSelected(wrap(menuScreen.getSelected() - 1, 1, numberOfOptions));
        }

        if(keycode == Input.Keys.S) {
            menuScreen.setSelected(wrap(menuScreen.getSelected() + 1, 1, numberOfOptions));
        }

        if(keycode == Input.Keys.ENTER || keycode == Input.Keys.SPACE) {
            if(menuScreen.getSelected() == 1) {
                stateMachine.changeState(new GameState());
            } else if(menuScreen.getSelected() == 2) {
                stateMachine.changeState(new OptionsState());
            } else if(menuScreen.getSelected() == 3) {
                Gdx.app.exit();
            }
        }

        updateArrowVisibility();

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private void updateArrowVisibility() {
        for(int i=0; i<menuScreen.getMenuImages().size(); i++) {
            if(i+1 == menuScreen.getSelected()) {
                menuScreen.getMenuImages().get(i).setVisible(true);
            } else {
                menuScreen.getMenuImages().get(i).setVisible(false);
            }
        }
    }

}
