package com.libgdx.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.libgdx.game.gamepad.XBox360GamePad;
import com.libgdx.game.screen.OptionsScreen;
import com.libgdx.game.state.MenuState;
import com.libgdx.game.state.StateMachine;

import static com.libgdx.game.util.Util.wrap;

public class OptionsInputProcessor implements InputProcessor, ControllerListener {

    private StateMachine stateMachine;
    private OptionsScreen optionsScreen;
    private boolean axisCanChange = true;

    public OptionsInputProcessor(StateMachine stateMachine, OptionsScreen optionsScreen) {
        this.stateMachine = stateMachine;
        this.optionsScreen = optionsScreen;
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {

        if(buttonCode == XBox360GamePad.BUTTON_A &&
                optionsScreen.getSelected() == 6) {
            stateMachine.changeState(new MenuState());
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {

        int numberOfOptions = 6;

        if(keycode == Input.Keys.W) {
            optionsScreen.setSelected(wrap(optionsScreen.getSelected() - 1, 1, numberOfOptions));
        }

        if(keycode == Input.Keys.S) {
            optionsScreen.setSelected(wrap(optionsScreen.getSelected() + 1, 1, numberOfOptions));
        }

        if(keycode == Input.Keys.ENTER || keycode == Input.Keys.SPACE) {
            if(optionsScreen.getSelected() == 6) {
                stateMachine.changeState(new MenuState());
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

    @Override
    public void connected(Controller controller) {

    }

    @Override
    public void disconnected(Controller controller) {

    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        int numberOfOptions = 6;

        if(axisCode == XBox360GamePad.AXIS_LEFT_Y) {
            if(value <= -0.99 && axisCanChange) {
                int s = wrap(optionsScreen.getSelected() - 1, 1, numberOfOptions);
                optionsScreen.setSelected(s);
                axisCanChange = false;
            }
            if(value >= 1 && axisCanChange) {
                int s = wrap(optionsScreen.getSelected() + 1, 1, numberOfOptions);
                optionsScreen.setSelected(s);
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

    private void updateArrowVisibility() {
        for(int i=0; i<optionsScreen.getOptionsImages().size(); i++) {
            if(i+1 == optionsScreen.getSelected()) {
                optionsScreen.getOptionsImages().get(i).setVisible(true);
            } else {
                optionsScreen.getOptionsImages().get(i).setVisible(false);
            }
        }
    }

}
