package ru.md.actors.objects;

/**
 * Created by Vladimir on 30.11.2017.
 */
public interface RenderableObject {
    public float getDrawX();
    public float getDrawY();
    public float getDrawZ();
    public default float getDrawAngle(){
        return 0.0f;
    }
}
