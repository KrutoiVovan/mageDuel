package ru.md.actors.objects;

import ru.md.actors.hexagon.Hexagon;

/**
 * Created by Vladimir on 28.11.2017.
 */
public abstract class GameObject implements RenderableObject {
    /*
        Абсолютные координаты(в хексагонах), местонахождения обьекта.
     */
    private Hexagon hexagon;

    /*
        Смещение обьекта по осям x, y и на угол, дле рендера.
     */
    private float xOffset, yOffset, Angle;
}
