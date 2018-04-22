package ru.md.eventhandle.handlers.mainmenu;

import ru.md.ClientMainFrame;
import ru.md.eventhandle.Event;
import ru.md.eventhandle.EventListener;
import ru.md.eventhandle.event.MainMenuButtonPressedEvent;
import ru.md.scene.MainMenuBackgroundScene;
import ru.md.scene.ui.MainMenuUIScene;
import ru.md.scene.ui.ServerLobbyUIScene;
import ru.md.scene.ui.UIScene;

/**
 * Created by Vladimir on 18.03.2018.
 */
public class ConnectButtonEventListener implements EventListener {
    @Override
    public boolean isApplicable(Event event) {
        return event.getClass().equals(MainMenuButtonPressedEvent.class)
                &&((MainMenuButtonPressedEvent) event).getType().equals(MainMenuButtonPressedEvent.EventType.CONNECT);
    }

    @Override
    public boolean handleEvent(Event event) {
        ClientMainFrame.clearScenes();
        ClientMainFrame.addScene(new MainMenuBackgroundScene());
        UIScene sceneUI = new ServerLobbyUIScene();
        ClientMainFrame.addScene(sceneUI);
        ClientMainFrame.setInputProcessor(sceneUI.getStageController());

        return true;
    }
}
