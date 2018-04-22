package ru.md.scene.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.md.eventhandle.GlobalEventListener;
import ru.md.eventhandle.event.MainMenuButtonPressedEvent;

/**
 * Created by Vladimir on 18.03.2018.
 */
public class ConnectUIScene extends UIScene {
    public ConnectUIScene() {
        Table table = new Table();
        stage.addActor(table);
        table.setFillParent(true);
        TextField textField = new TextField("", createTextFieldStyle());
        table.add(new Label("Enter ip adress of host:", new Label.LabelStyle(new BitmapFont(), Color.WHITE))).pad(padding);
        table.add(textField).pad(padding);
        table.row();

        TextButton connectButton = new TextButton("Connect", createButtonStyle());
        TextButton backButton = new TextButton("Back", createButtonStyle());

        connectButton.addListener(e -> {
            if(e.getClass().equals(InputEvent.class))
                if(((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                    GlobalEventListener.handleEvent(new MainMenuButtonPressedEvent(MainMenuButtonPressedEvent.EventType.CONNECT));
            return true;
        });
        backButton.addListener(e -> {
            if(e.getClass().equals(InputEvent.class))
                if(((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                    GlobalEventListener.handleEvent(new MainMenuButtonPressedEvent(MainMenuButtonPressedEvent.EventType.BACK));
            return true;
        });
        table.add(connectButton).pad(padding);
        table.add(backButton).pad(padding);
    }
}
