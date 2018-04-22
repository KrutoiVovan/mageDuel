package ru.md.utils.singletones;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;
import ru.md.actors.objects.LinkedModelInstance;
import ru.md.actors.objects.RenderableObject;

import java.util.*;

/**
 * Created by Vladimir on 22.12.2017.
 */
public class ModelManager {
    private static final AssetManager assets = new AssetManager();
    private static final Set<ModelInstance> instances = new HashSet<ModelInstance>();

    public static void loadModel(String fileName){
        assets.load(fileName, Model.class);
    }

    public static boolean checkLoad(){
        return assets.update();
    }

    //Использутеся для непостоянных обьетов, которым не нужны ссылки на пораждающий обьект.
    public static ModelInstance persistModelInstance(String fileName){
        Model hexModel = assets.get(fileName, Model.class);
        ModelInstance instance = new ModelInstance(hexModel);
        instances.add(instance);
        return instance;
    }

    //Используется для обьектов, которые имеют ссылку на реальные обьекты игры.
    public static ModelInstance persistLinkedModelInstance(String fileName, RenderableObject parent){
        Model hexModel = assets.get(fileName, Model.class);
        ModelInstance instance = new LinkedModelInstance(hexModel, parent);
        instances.add(instance);
        return instance;
    }

    public static Set<ModelInstance> getInstances() {
        return instances;
    }

    public static boolean deleteInstance(ModelInstance instance){
        return instances.remove(instance);
    }

    public static AssetManager getAssets() {
        return assets;
    }

    public static void dispose(){
        Array<Model> arr = new Array<>();
        assets.getAll(Model.class, arr).forEach(Model::dispose);
    }
}
