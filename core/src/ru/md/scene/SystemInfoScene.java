package ru.md.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Vladimir on 17.03.2018.
 */
public class SystemInfoScene implements Scene {
    private Stage stage;
    private StringBuilder stringBuilder = new StringBuilder();
    private Label label;
    private BitmapFont font;
    private final int textMargin = 10;

    public SystemInfoScene() {
        stage = new Stage();
        font = new BitmapFont();
        label = new Label("", new Label.LabelStyle(font, Color.WHITE));
        label.setX(label.getX() + textMargin / 2);
        label.setY(label.getY() + textMargin);
        stage.addActor(label);
    }

    @Override
    public void render() {
        stringBuilder.setLength(0);
        stringBuilder.append(" FPS: ").append(Gdx.graphics.getFramesPerSecond());
        label.setText(stringBuilder);
        stage.draw();
    }

    @Override
    public void dispose() {
        font.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
