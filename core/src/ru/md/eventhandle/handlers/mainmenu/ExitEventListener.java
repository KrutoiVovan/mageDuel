package ru.md.eventhandle.handlers.mainmenu;

import com.badlogic.gdx.Gdx;
import ru.md.ClientMainFrame;
import ru.md.eventhandle.Event;
import ru.md.eventhandle.EventListener;
import ru.md.eventhandle.event.MainMenuButtonPressedEvent;
import ru.md.scene.MainMenuBackgroundScene;
import ru.md.scene.ui.ConnectUIScene;

/**
 * Created by Vladimir on 18.03.2018.
 */
public class ExitEventListener implements EventListener {
    @Override
    public boolean isApplicable(Event event) {
        return event.getClass().equals(MainMenuButtonPressedEvent.class)
                &&((MainMenuButtonPressedEvent) event).getType().equals(MainMenuButtonPressedEvent.EventType.EXIT);
    }

    @Override
    public boolean handleEvent(Event event) {
        Gdx.app.exit();
        return true;
    }

}
