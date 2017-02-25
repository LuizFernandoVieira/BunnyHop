package com.libgdx.game.servicelocator.stage;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class StageLocator {

    private static Stage service;

    public static void provide(Stage stage) {
        service = stage;
    }

    public static Stage getStage() {
        return service;
    }

}
