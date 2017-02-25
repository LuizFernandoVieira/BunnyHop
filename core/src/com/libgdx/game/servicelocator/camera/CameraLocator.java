package com.libgdx.game.servicelocator.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraLocator {

    private static OrthographicCamera service;

    public static void provide(OrthographicCamera camera) {
        service = camera;
    }

    public static OrthographicCamera getCamera() {
        return service;
    }

}
