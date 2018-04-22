package ru.md.eventhandle;

/**
 * Created by Vladimir on 18.03.2018.
 * Интерфейс EventListener, обработчика Event'ов.
 */
public interface EventListener {
    public boolean isApplicable(Event event);
    public boolean handleEvent(Event event);
}
