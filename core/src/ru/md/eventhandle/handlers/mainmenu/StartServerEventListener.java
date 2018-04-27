package ru.md.eventhandle.handlers.mainmenu;

import ru.md.ClientMainFrame;
import ru.md.eventhandle.Event;
import ru.md.eventhandle.EventListener;
import ru.md.eventhandle.event.MainMenuButtonPressedEvent;
import ru.md.scene.ui.MainMenuUIScene;

/**
 * Created by Vladimir on 18.03.2018.
 */
public class StartServerEventListener implements EventListener {
    @Override
    public boolean isApplicable(Event event) {
        return event.getClass().equals(MainMenuButtonPressedEvent.class)
                &&((MainMenuButtonPressedEvent) event).getType().equals(MainMenuButtonPressedEvent.EventType.START_NEW);
    }

    @Override
    public boolean handleEvent(Event event) {

        ClientMainFrame.clearScenes();
        MainMenuUIScene scene = new MainMenuUIScene();
        ClientMainFrame.addScene(scene);
        ClientMainFrame.setInputProcessor(scene.getStageController());
        return true;
    }
}
