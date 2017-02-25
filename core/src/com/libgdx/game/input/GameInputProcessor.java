package com.libgdx.game.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.libgdx.game.entities.beans.player.Player;

public class GameInputProcessor implements InputProcessor, ControllerListener {

    private Player player;

    public void initDependencies(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {

        if(keycode == Keys.W && player != null) {

        }

        if(keycode == Keys.D && player != null) {
            player.setMoveRight(true);
        }

        if(keycode == Keys.S && player != null) {

        }

        if(keycode == Keys.A && player != null) {
            player.setMoveLeft(true);
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if(keycode == Keys.W && player != null) {

        }

        if(keycode == Keys.D && player != null) {
            player.setMoveRight(false);
        }

        if(keycode == Keys.S && player != null) {

        }

        if(keycode == Keys.A && player != null) {
            player.setMoveLeft(false);
        }

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
    public boolean buttonDown(Controller controller, int buttonCode) {

        // up
        if(buttonCode == 0) {

        }

        // down
        if(buttonCode == 1) {

        }

        // left
        if(buttonCode == 2) {

        }

        // right
        if(buttonCode == 3) {

        }

        // x
        if(buttonCode == 9) {

        }

        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {

        // up
        if(buttonCode == 0) {

        }

        // down
        if(buttonCode == 1) {

        }

        // left
        if(buttonCode == 2) {

        }

        // right
        if(buttonCode == 3) {

        }

        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
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

}
