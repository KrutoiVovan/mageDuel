package ru.md.eventhandle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by Vladimir on 18.03.2018.
 * Класс, являющийся композитом всех хэндлеров, обрабатывающих
 * ивенты игры.
 */
public class GlobalEventListener {

    //Singletone
    private GlobalEventListener(){
    }
    private final static ArrayList<EventListener> listeners = new ArrayList<>();

    public static void addListener(EventListener listener){
        listeners.add(listener);
    }

    public static void addListeners(Collection<EventListener> listeners){
        GlobalEventListener.listeners.addAll(listeners);
    }

    public static void resetListeners(){
        listeners.clear();
    }

    public static void handleEvent(Event event){
        for(EventListener listener: listeners)
            if(listener.isApplicable(event))
                if(listener.handleEvent(event))
                    return;
    }
}
