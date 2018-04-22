package ru.md.controller;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import ru.md.scene.Scene;

/**
 * Created by Vladimir on 17.03.2018.
 * Обычный контроллер ввода, camerController + удаление всех элементов
 */
public class DisposeInputController extends CameraInputController {


    protected static class GestureListener extends CameraInputController.CameraGestureListener{
        private Scene scene;

        public GestureListener() {
        }

        public GestureListener(Scene myScene) {
            this.scene = myScene;
        }

        @Override
        public boolean tap(float x, float y, int count, int button) {
            System.out.println("DONE!");
            scene.dispose();
            return false;
        }
    }
    protected DisposeInputController(CameraGestureListener gestureListener, Camera camera) {
        super(gestureListener, camera);
    }

    public DisposeInputController(Camera camera) {
        this(new GestureListener(), camera);
    }

    public DisposeInputController(Camera camer, Scene myScene){
        this(new GestureListener(myScene), camer);
    }

}
