package ru.md.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;
import ru.md.actors.hexagon.Hexagon;
import ru.md.utils.properties.PropertiesManager;
import ru.md.utils.singletones.ModelManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 17.03.2018.
 * Класс, отрисовывающий сцену в главном меню.
 */
public class MainMenuBackgroundScene implements Scene{

    private PerspectiveCamera cam;
    private ModelBatch modelBatch;
    private Environment environment;
    private List<Hexagon> hexes = new ArrayList<>();

    public MainMenuBackgroundScene(){
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
        modelBatch = new ModelBatch();

        cam = new PerspectiveCamera(90, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(-5f, 5f, -0f);
        cam.lookAt(10, 0, 10);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        ModelManager.loadModel("assets/Hexagon.g3db");

        while (!ModelManager.checkLoad())
            System.out.println("loading");
        for (int j = 0; j < 10; j++)
            for (int i = 0; i < 10; i++) {
                hexes.add(new Hexagon(i, j));
            }

    }


    @Override
    public void render() {
        modelBatch.begin(cam);
        hexes.stream()
                .map(Hexagon::getModelInstance)
                .filter(this::isVisible)
                .forEach(x -> modelBatch.render(x, environment));
        modelBatch.end();
    }

    private boolean isVisible(ModelInstance instance) {
        Vector3 vector = new Vector3();
        instance.transform.getTranslation(vector);
        return cam.frustum.sphereInFrustum(vector, PropertiesManager.getFrustumRadius());
    }

    @Override
    public void dispose() {
        hexes.clear();
        modelBatch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        cam.viewportWidth = width;
        cam.viewportHeight = height;
        cam.update();
    }

    public Camera getCamera() {
        return cam;
    }
}
