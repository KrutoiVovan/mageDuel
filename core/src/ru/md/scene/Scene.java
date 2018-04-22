package ru.md.scene;

/**
 * Created by Vladimir on 17.03.2018.
 */
public interface Scene {
    public void render();
    public void dispose();
    public void resize(int width, int height);
}
