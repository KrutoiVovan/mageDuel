package ru.md.actors.hexagon;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import ru.md.utils.properties.PropertiesManager;
import ru.md.utils.singletones.ModelManager;

/**
 * Created by Vladimir on 28.11.2017.
 */
public class Hexagon implements ru.md.actors.objects.RenderableObject {

    private final int x, y;
    private final ModelInstance modelInstance;
    private HexagonType hexType = HexagonType.BRICK;

    public Hexagon(int x, int y) {
        this.x = x;
        this.y = y;
        this.modelInstance = ModelManager.persistModelInstance(hexType.getModelName());
        modelInstance.transform.setToTranslation(getDrawX(), getDrawY(), getDrawZ());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public float getDrawX(){
        return (PropertiesManager.getScale() + PropertiesManager.getMargin()) * (x + (y % 2) / 2.0f) ;
    }

    @Override
    public float getDrawY() {
        return 0.0f;
    }

    @Override
    public float getDrawZ(){
        return (float) ((PropertiesManager.getScaleZ() + PropertiesManager.getMargin()) * Math.sqrt(3)/2.0f * y);
    }

    public ModelInstance getModelInstance() {
        return modelInstance;
    }
}
