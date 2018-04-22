package ru.md;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import ru.md.eventhandle.GlobalEventListener;
import ru.md.eventhandle.handlers.mainmenu.*;
import ru.md.scene.MainMenuBackgroundScene;
import ru.md.scene.ui.MainMenuUIScene;
import ru.md.scene.Scene;
import ru.md.scene.SystemInfoScene;
import ru.md.utils.properties.PropertiesManager;
import ru.md.utils.singletones.ModelManager;

import java.util.ArrayList;

public class ClientMainFrame extends ApplicationAdapter {
    private static ArrayList<Scene> scenes = new ArrayList<>();

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(PropertiesManager.getWidht(), PropertiesManager.getHeight());
        if (PropertiesManager.isFullscreen())
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        Gdx.graphics.setTitle("Mage duel");
        MainMenuBackgroundScene stage = new MainMenuBackgroundScene();
        MainMenuUIScene menuUIScene = new MainMenuUIScene();
        initMenuListeners();
        scenes.add(stage);
        scenes.add(menuUIScene);
        scenes.add(new SystemInfoScene());
        InputProcessor inputController = menuUIScene.getStageController();
        Gdx.input.setInputProcessor(inputController);

    }

    private void initMenuListeners() {
        GlobalEventListener.addListener(new StartServerEventListener());
        GlobalEventListener.addListener(new NavigateConnectEventListener());
        GlobalEventListener.addListener(new ConnectButtonEventListener());
        GlobalEventListener.addListener(new BackButtonEventListener());
        GlobalEventListener.addListener(new ExitEventListener());
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        scenes.forEach(Scene::render);
    }

    @Override
    public void resize(int width, int height) {
        scenes.forEach(x ->x.resize(width, height));
    }

    @Override
    public void dispose() {
        ModelManager.dispose();
    }

    public static void clearScenes(){
        scenes.forEach(Scene::dispose);
        scenes.clear();
    }

    public static void addScene(Scene scene){
        scenes.add(scene);
    }

    public static void setInputProcessor(InputProcessor inputProcessor){
        Gdx.input.setInputProcessor(inputProcessor);
    }

}
