package com.libgdx.game.entities.beans.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.libgdx.game.servicelocator.camera.CameraLocator;
import com.libgdx.game.servicelocator.stage.StageLocator;
import com.libgdx.game.util.Constants;

public class EngineMap extends Map {

    private Stage stage;
    private Skin skin;

    private Table table;

    private final Table subTable1 = new Table();
    private final Table subTable2 = new Table();
    private final Table subTable3 = new Table();
    private final Table subTable4 = new Table();
    private final Table subTable5 = new Table();

    private Drawable selectedDrawable;
    private Image selectedImage;

    private ImageButtonStyle playerBtnStyle;
    private ImageButtonStyle tilesBtnStyle;
    private ImageButtonStyle itemsBtnStyle;
    private ImageButtonStyle enemiesBtnStyle;
    private ImageButtonStyle backgroundsBtnStyle;
    private ImageButtonStyle saveBtnStyle;
    private ImageButtonStyle exitBtnStyle;

    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private ImageButton btn7;

    public EngineMap() {
        stage = StageLocator.getStage();
        Gdx.input.setInputProcessor(stage);

        FileHandle handle = Gdx.files.internal("gui/editor/uiskin.json");
        skin = new Skin(handle);

        createMainTable();
        createImageButtonStyles();
        createMainImageButtonsAndAddToTable();
        addListenersToMainImageButtons();
        createSubtables();
        hideAllSubtables();
        createSubTablesImageButtonsAndAddToSubtable();
        addListenersToSubtablesImageButtons();
        addTablesToStage();
    }

    @Override
    public void update() {
        if(selectedImage != null) {
            System.out.println(Gdx.input.getX());
            Vector3 input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            CameraLocator.getCamera().unproject(input);
            selectedImage.setPosition(
                    input.x - selectedImage.getWidth()/2,
                    input.y - selectedImage.getHeight()/2
            );
        }
    }

    @Override
    public void draw() {

    }

    private void hideAllSubtables() {
        subTable1.setVisible(false);
        subTable2.setVisible(false);
        subTable3.setVisible(false);
        subTable4.setVisible(false);
        subTable5.setVisible(false);
    }

    private void createMainTable() {
        Texture tableTexture = new Texture(Gdx.files.internal("gui/editor/tableTeste.9.png"));
        NinePatch tableNinePatch = new NinePatch(tableTexture);
        NinePatchDrawable tableNinePatchDrawable = new NinePatchDrawable(tableNinePatch);

        table = new Table(skin);
        table.setBackground(tableNinePatchDrawable);
        table.setWidth(Constants.CAMERA_WIDTH);
        table.setHeight(Constants.CAMERA_HEIGHT / 6);
        table.setPosition(0, Constants.CAMERA_HEIGHT - Constants.CAMERA_HEIGHT / 5);
        table.top().center().padTop(4);
    }

    private void createImageButtonStyles() {
        playerBtnStyle = new ImageButtonStyle(
                skin.getDrawable("player_btn"), skin.getDrawable("player_button_pressed"),
                skin.getDrawable("player_btn"), skin.getDrawable("player_btn"),
                skin.getDrawable("player_button_pressed"), skin.getDrawable("player_btn"));

        tilesBtnStyle = new ImageButtonStyle(
                skin.getDrawable("tile_btn"), skin.getDrawable("tile_button_pressed"),
                skin.getDrawable("tile_btn"), skin.getDrawable("tile_btn"),
                skin.getDrawable("tile_button_pressed"), skin.getDrawable("tile_btn"));

        itemsBtnStyle = new ImageButtonStyle(
                skin.getDrawable("item_btn"), skin.getDrawable("item_button_pressed"),
                skin.getDrawable("item_btn"), skin.getDrawable("item_btn"),
                skin.getDrawable("item_button_pressed"), skin.getDrawable("item_btn"));

        enemiesBtnStyle = new ImageButtonStyle(
                skin.getDrawable("enemy_btn"), skin.getDrawable("enemy_button_pressed"),
                skin.getDrawable("enemy_btn"), skin.getDrawable("enemy_btn"),
                skin.getDrawable("enemy_button_pressed"), skin.getDrawable("enemy_btn"));

        backgroundsBtnStyle = new ImageButtonStyle(
                skin.getDrawable("background_btn"), skin.getDrawable("background_button_pessed"),
                skin.getDrawable("background_btn"), skin.getDrawable("background_btn"),
                skin.getDrawable("background_button_pessed"), skin.getDrawable("background_btn"));

        saveBtnStyle = new ImageButtonStyle(
                skin.getDrawable("save_btn"), skin.getDrawable("save_button_pessed"),
                skin.getDrawable("save_btn"), skin.getDrawable("save_btn"),
                skin.getDrawable("save_button_pessed"), skin.getDrawable("save_btn"));

        exitBtnStyle = new ImageButtonStyle(
                skin.getDrawable("exit_btn"), skin.getDrawable("exit_btn_pessed"),
                skin.getDrawable("exit_btn"), skin.getDrawable("exit_btn"),
                skin.getDrawable("exit_btn_pessed"), skin.getDrawable("exit_btn"));
    }

    private void createMainImageButtonsAndAddToTable() {
        btn1 = new ImageButton(playerBtnStyle);
        btn2 = new ImageButton(tilesBtnStyle);
        btn3 = new ImageButton(itemsBtnStyle);
        btn4 = new ImageButton(enemiesBtnStyle);
        btn5 = new ImageButton(backgroundsBtnStyle);
        btn6 = new ImageButton(saveBtnStyle);
        btn7 = new ImageButton(exitBtnStyle);

        table.add(btn1).padRight(2);
        table.add(btn2).padRight(2);
        table.add(btn3).padRight(2);
        table.add(btn4).padRight(2);
        table.add(btn5).padRight(2);
        table.add(btn6).padRight(2);
        table.add(btn7).padRight(2);
    }

    private void addListenersToMainImageButtons() {
        btn1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(subTable1.isVisible()) {
                    subTable1.setVisible(false);
                } else {
                    hideAllSubtables();
                    subTable1.setVisible(true);
                }
            }
        });

        btn2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(subTable2.isVisible()) {
                    subTable2.setVisible(false);
                } else {
                    hideAllSubtables();
                    subTable2.setVisible(true);
                }
            }
        });

        btn3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(subTable3.isVisible()) {
                    subTable3.setVisible(false);
                } else {
                    hideAllSubtables();
                    subTable3.setVisible(true);
                }
            }
        });

        btn4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(subTable4.isVisible()) {
                    subTable4.setVisible(false);
                } else {
                    hideAllSubtables();
                    subTable4.setVisible(true);
                }
            }
        });

        btn5.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(subTable5.isVisible()) {
                    subTable5.setVisible(false);
                } else {
                    hideAllSubtables();
                    subTable5.setVisible(true);
                }
            }
        });
    }

    private void createSubtables() {
        Texture subTableTexture = new Texture(Gdx.files.internal("gui/editor/subtable.9.png"));
        TextureRegion subTableRegion = new TextureRegion(subTableTexture);
        Drawable subTableDrawable = new TextureRegionDrawable(subTableRegion);

        subTable1.setWidth(Constants.CAMERA_WIDTH);
        subTable1.setHeight(Constants.CAMERA_HEIGHT / 6);
        subTable1.setBackground(subTableDrawable);
        subTable1.setPosition(0, Constants.CAMERA_HEIGHT - 55);
        subTable1.center().top().padTop(24);

        subTable2.setWidth(Constants.CAMERA_WIDTH);
        subTable2.setHeight(Constants.CAMERA_HEIGHT);
        subTable2.center().top().padTop(24);

        subTable3.setWidth(Constants.CAMERA_WIDTH);
        subTable3.setHeight(Constants.CAMERA_HEIGHT);
        subTable3.center().top().padTop(24);

        subTable4.setWidth(Constants.CAMERA_WIDTH);
        subTable4.setHeight(Constants.CAMERA_HEIGHT);
        subTable4.center().top().padTop(24);

        subTable5.setWidth(Constants.CAMERA_WIDTH);
        subTable5.setHeight(Constants.CAMERA_HEIGHT);
        subTable5.center().top().padTop(24);
    }

    private void createSubTablesImageButtonsAndAddToSubtable() {
        createSubTablesImageButtonsAndAddToPlayerSubtable();
        createSubTablesImageButtonsAndAddToTilesSubtable();
        createSubTablesImageButtonsAndAddToItemsSubtable();
        createSubTablesImageButtonsAndAddToEnemiesSubtable();
        createSubTablesImageButtonsAndAddToBackgroundsSubtable();
    }

    public void createSubTablesImageButtonsAndAddToPlayerSubtable() {
        ImageButtonStyle subTable1_imageButton_1_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_2_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_3_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_4_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_5_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_6_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_7_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_8_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_9_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        ImageButtonStyle subTable1_imageButton_10_style = new ImageButtonStyle(skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"), skin.getDrawable("default_btn"));
        final ImageButton subTable1_btn1 = new ImageButton(subTable1_imageButton_1_style);
        final ImageButton subTable1_btn2 = new ImageButton(subTable1_imageButton_2_style);
        final ImageButton subTable1_btn3 = new ImageButton(subTable1_imageButton_3_style);
        final ImageButton subTable1_btn4 = new ImageButton(subTable1_imageButton_4_style);
        final ImageButton subTable1_btn5 = new ImageButton(subTable1_imageButton_5_style);
        final ImageButton subTable1_btn6 = new ImageButton(subTable1_imageButton_6_style);
        final ImageButton subTable1_btn7 = new ImageButton(subTable1_imageButton_7_style);
        final ImageButton subTable1_btn8 = new ImageButton(subTable1_imageButton_8_style);
        final ImageButton subTable1_btn9 = new ImageButton(subTable1_imageButton_9_style);
        final ImageButton subTable1_btn10 = new ImageButton(subTable1_imageButton_10_style);
        subTable1.add(subTable1_btn1).pad(2);
        subTable1.add(subTable1_btn2).pad(2);
        subTable1.add(subTable1_btn3).pad(2);
        subTable1.add(subTable1_btn4).pad(2);
        subTable1.add(subTable1_btn5).pad(2);
        subTable1.row();
        subTable1.add(subTable1_btn6);
        subTable1.add(subTable1_btn7);
        subTable1.add(subTable1_btn8);
        subTable1.add(subTable1_btn9);
        subTable1.add(subTable1_btn10);
    }

    private void createSubTablesImageButtonsAndAddToTilesSubtable() {
        ImageButtonStyle subTable2_imageButton_1_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_2_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_3_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_4_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_5_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_6_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_7_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_8_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_9_style = new ImageButtonStyle();
        ImageButtonStyle subTable2_imageButton_10_style = new ImageButtonStyle();
        ImageButton subTable2_btn1 = new ImageButton(subTable2_imageButton_1_style);
        ImageButton subTable2_btn2 = new ImageButton(subTable2_imageButton_2_style);
        ImageButton subTable2_btn3 = new ImageButton(subTable2_imageButton_3_style);
        ImageButton subTable2_btn4 = new ImageButton(subTable2_imageButton_4_style);
        ImageButton subTable2_btn5 = new ImageButton(subTable2_imageButton_5_style);
        ImageButton subTable2_btn6 = new ImageButton(subTable2_imageButton_6_style);
        ImageButton subTable2_btn7 = new ImageButton(subTable2_imageButton_7_style);
        ImageButton subTable2_btn8 = new ImageButton(subTable2_imageButton_8_style);
        ImageButton subTable2_btn9 = new ImageButton(subTable2_imageButton_9_style);
        ImageButton subTable2_btn10 = new ImageButton(subTable2_imageButton_10_style);
        subTable2.add(subTable2_btn1);
        subTable2.add(subTable2_btn2);
        subTable2.add(subTable2_btn3);
        subTable2.add(subTable2_btn4);
        subTable2.add(subTable2_btn5);
        subTable2.add(subTable2_btn6);
        subTable2.add(subTable2_btn7);
        subTable2.add(subTable2_btn8);
        subTable2.add(subTable2_btn9);
        subTable2.add(subTable2_btn10);
    }

    private void createSubTablesImageButtonsAndAddToItemsSubtable() {
        ImageButtonStyle subTable3_imageButton_1_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_2_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_3_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_4_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_5_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_6_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_7_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_8_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_9_style = new ImageButtonStyle();
        ImageButtonStyle subTable3_imageButton_10_style = new ImageButtonStyle();
        ImageButton subTable3_btn1 = new ImageButton(subTable3_imageButton_1_style);
        ImageButton subTable3_btn2 = new ImageButton(subTable3_imageButton_2_style);
        ImageButton subTable3_btn3 = new ImageButton(subTable3_imageButton_3_style);
        ImageButton subTable3_btn4 = new ImageButton(subTable3_imageButton_4_style);
        ImageButton subTable3_btn5 = new ImageButton(subTable3_imageButton_5_style);
        ImageButton subTable3_btn6 = new ImageButton(subTable3_imageButton_6_style);
        ImageButton subTable3_btn7 = new ImageButton(subTable3_imageButton_7_style);
        ImageButton subTable3_btn8 = new ImageButton(subTable3_imageButton_8_style);
        ImageButton subTable3_btn9 = new ImageButton(subTable3_imageButton_9_style);
        ImageButton subTable3_btn10 = new ImageButton(subTable3_imageButton_10_style);
        subTable3.add(subTable3_btn1);
        subTable3.add(subTable3_btn2);
        subTable3.add(subTable3_btn3);
        subTable3.add(subTable3_btn4);
        subTable3.add(subTable3_btn5);
        subTable3.add(subTable3_btn6);
        subTable3.add(subTable3_btn7);
        subTable3.add(subTable3_btn8);
        subTable3.add(subTable3_btn9);
        subTable3.add(subTable3_btn10);
    }

    private void createSubTablesImageButtonsAndAddToEnemiesSubtable() {
        ImageButtonStyle subTable4_imageButton_1_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_2_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_3_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_4_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_5_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_6_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_7_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_8_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_9_style = new ImageButtonStyle();
        ImageButtonStyle subTable4_imageButton_10_style = new ImageButtonStyle();
        ImageButton subTable4_btn1 = new ImageButton(subTable4_imageButton_1_style);
        ImageButton subTable4_btn2 = new ImageButton(subTable4_imageButton_2_style);
        ImageButton subTable4_btn3 = new ImageButton(subTable4_imageButton_3_style);
        ImageButton subTable4_btn4 = new ImageButton(subTable4_imageButton_4_style);
        ImageButton subTable4_btn5 = new ImageButton(subTable4_imageButton_5_style);
        ImageButton subTable4_btn6 = new ImageButton(subTable4_imageButton_6_style);
        ImageButton subTable4_btn7 = new ImageButton(subTable4_imageButton_7_style);
        ImageButton subTable4_btn8 = new ImageButton(subTable4_imageButton_8_style);
        ImageButton subTable4_btn9 = new ImageButton(subTable4_imageButton_9_style);
        ImageButton subTable4_btn10 = new ImageButton(subTable4_imageButton_10_style);
        subTable4.add(subTable4_btn1);
        subTable4.add(subTable4_btn2);
        subTable4.add(subTable4_btn3);
        subTable4.add(subTable4_btn4);
        subTable4.add(subTable4_btn5);
        subTable4.add(subTable4_btn6);
        subTable4.add(subTable4_btn7);
        subTable4.add(subTable4_btn8);
        subTable4.add(subTable4_btn9);
        subTable4.add(subTable4_btn10);
    }

    private void createSubTablesImageButtonsAndAddToBackgroundsSubtable() {
        ImageButtonStyle subTable5_imageButton_1_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_2_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_3_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_4_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_5_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_6_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_7_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_8_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_9_style = new ImageButtonStyle();
        ImageButtonStyle subTable5_imageButton_10_style = new ImageButtonStyle();
        ImageButton subTable5_btn1 = new ImageButton(subTable5_imageButton_1_style);
        ImageButton subTable5_btn2 = new ImageButton(subTable5_imageButton_2_style);
        ImageButton subTable5_btn3 = new ImageButton(subTable5_imageButton_3_style);
        ImageButton subTable5_btn4 = new ImageButton(subTable5_imageButton_4_style);
        ImageButton subTable5_btn5 = new ImageButton(subTable5_imageButton_5_style);
        ImageButton subTable5_btn6 = new ImageButton(subTable5_imageButton_6_style);
        ImageButton subTable5_btn7 = new ImageButton(subTable5_imageButton_7_style);
        ImageButton subTable5_btn8 = new ImageButton(subTable5_imageButton_8_style);
        ImageButton subTable5_btn9 = new ImageButton(subTable5_imageButton_9_style);
        ImageButton subTable5_btn10 = new ImageButton(subTable5_imageButton_10_style);
        subTable5.add(subTable5_btn1);
        subTable5.add(subTable5_btn2);
        subTable5.add(subTable5_btn3);
        subTable5.add(subTable5_btn4);
        subTable5.add(subTable5_btn5);
        subTable5.add(subTable5_btn6);
        subTable5.add(subTable5_btn7);
        subTable5.add(subTable5_btn8);
        subTable5.add(subTable5_btn9);
        subTable5.add(subTable5_btn10);
    }

    private void addListenersToSubtablesImageButtons() {
        Array<Cell> cellsSubTable1 = subTable1.getCells();
        for(final Cell cell : cellsSubTable1) {
            cell.getActor().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    selectedImage = ((ImageButton)cell.getActor()).getImage();
                    stage.addActor(selectedImage);
                }
            });
        }

        Array<Cell> cellsSubTable2 = subTable2.getCells();
        for(final Cell cell : cellsSubTable2) {
            cell.getActor().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    selectedImage = ((ImageButton)cell.getActor()).getImage();
                    stage.addActor(selectedImage);
                }
            });
        }

        Array<Cell> cellsSubTable3 = subTable3.getCells();
        for(final Cell cell : cellsSubTable3) {
            cell.getActor().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    selectedImage = ((ImageButton)cell.getActor()).getImage();
                    stage.addActor(selectedImage);
                }
            });
        }

        Array<Cell> cellsSubTable4 = subTable4.getCells();
        for(final Cell cell : cellsSubTable4) {
            cell.getActor().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    selectedImage = ((ImageButton)cell.getActor()).getImage();
                    stage.addActor(selectedImage);
                }
            });
        }

        Array<Cell> cellsSubTable5 = subTable5.getCells();
        for(final Cell cell : cellsSubTable5) {
            cell.getActor().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    selectedImage = ((ImageButton)cell.getActor()).getImage();
                    stage.addActor(selectedImage);
                }
            });
        }
    }

    private void addTablesToStage() {
        stage.addActor(table);
        stage.addActor(subTable1);
        stage.addActor(subTable2);
        stage.addActor(subTable3);
        stage.addActor(subTable4);
        stage.addActor(subTable5);
    }

    private void calculateCoordinateToDraw() {

    }

}
