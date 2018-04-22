package ru.md.actors.hexagon;

/**
 * Created by Vladimir on 28.11.2017.
 */
public enum HexagonType {
    BRICK("assets/Hexagon.g3db"),
    LAVA("assets/Hexagon.g3db"),
    ROCK("assets/Hexagon.g3db");

    private final String modelName;

    HexagonType(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}
