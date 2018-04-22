package ru.md.eventhandle.event;

import ru.md.eventhandle.Event;

/**
 * Created by Vladimir on 18.03.2018.
 */
public class MainMenuButtonPressedEvent extends Event {
    public enum EventType {
        START_NEW,
        NAVIGATE_CONNECT,
        CONNECT,
        BACK,
        EXIT
    }

    EventType type;
    public MainMenuButtonPressedEvent(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}
