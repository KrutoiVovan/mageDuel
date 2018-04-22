package ru.md.scene.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.md.scene.Scene;


/**
 * Created by Vladimir on 18.03.2018.
 */
public class UIScene implements Scene {

    Stage stage;
    private TextButton.TextButtonStyle textButtonStyle;
    private TextField.TextFieldStyle textFieldStyle;
    protected float padding = 5.0f,
                    verticalPadding = 10.0f,
                    horizontalPadding = 10.0f;

    public UIScene() {
        this.stage = new Stage();
    }

    @Override
    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    protected TextButton.TextButtonStyle createButtonStyle() {
        if(textButtonStyle != null)
            return textButtonStyle;
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        Texture buttonTexture = new Texture("assets/pic/buttonBackground.png");
        SpriteDrawable drawable = new SpriteDrawable(new Sprite(buttonTexture));
        style.up = drawable;
        style.checked = style.up;
        style.over = drawable.tint(Color.ORANGE);
        style.down = drawable.tint(Color.CYAN);
        style.checkedOver = style.over;
        style.font = new BitmapFont();
        textButtonStyle = style;
        return style;
    }

    protected TextField.TextFieldStyle createTextFieldStyle(){
        if(textFieldStyle != null)
            return textFieldStyle;
        Drawable textFieldBackground = new SpriteDrawable(new Sprite(new Texture("assets/pic/textFieldBackground.png")));
        TextField.TextFieldStyle style =
                new TextField.TextFieldStyle(new BitmapFont(), Color.WHITE, null, null, textFieldBackground);
        textFieldStyle = style;
        return style;
    }

    public InputProcessor getStageController() {
        return stage;
    }

}
