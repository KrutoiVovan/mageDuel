package ru.md.actors.objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

/**
 * Created by Vladimir on 26.12.2017.
 */
public class LinkedModelInstance extends ModelInstance {

    final RenderableObject gameEntity;

    public LinkedModelInstance(Model model, RenderableObject gameEntity) {
        super(model);
        this.gameEntity = gameEntity;
    }

    public RenderableObject getGameEntity(){
        return gameEntity;
    }
}
