package ru.md.scene.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import ru.md.eventhandle.GlobalEventListener;
import ru.md.eventhandle.event.MainMenuButtonPressedEvent;

/**
 * Created by Vladimir on 17.03.2018.
 */
public class MainMenuUIScene extends UIScene {


    public MainMenuUIScene() {
        stage = new Stage();
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton.TextButtonStyle style = createButtonStyle();

        TextButton startServerButton = new TextButton("Start new server", style);
        TextButton connectToSession = new TextButton("Connect to game", style);
        TextButton exitGameButton = new TextButton("Exit game", style);

        startServerButton.addListener((event) -> {
            if (event.getClass().equals(InputEvent.class))
                if (((InputEvent) event).getType() == InputEvent.Type.touchDown)
                    GlobalEventListener.handleEvent(new MainMenuButtonPressedEvent(MainMenuButtonPressedEvent.EventType.START_NEW));
            return true;
        });

        connectToSession.addListener((event) -> {
            if (event.getClass().equals(InputEvent.class))
                if (((InputEvent) event).getType() == InputEvent.Type.touchDown)
                    GlobalEventListener.handleEvent(new MainMenuButtonPressedEvent(MainMenuButtonPressedEvent.EventType.NAVIGATE_CONNECT));
            return true;
        });

        exitGameButton.addListener((event) -> {
            if (event.getClass().equals(InputEvent.class))
                if (((InputEvent) event).getType() == InputEvent.Type.touchDown)
                    GlobalEventListener.handleEvent(new MainMenuButtonPressedEvent(MainMenuButtonPressedEvent.EventType.EXIT));
            return true;
        });

        table.center().add(startServerButton).padBottom(verticalPadding);
        table.row();
        table.add(connectToSession).padBottom(verticalPadding);
        table.row();
        table.add(exitGameButton);
    }

}
