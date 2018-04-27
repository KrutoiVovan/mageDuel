package ru.md.actors.hexagon;

/**
 * Created by Vladimir on 28.11.2017.
 */
public enum HexagonType {
    BRICK("Hexagon.g3db"),
    LAVA("Hexagon.g3db"),
    ROCK("Hexagon.g3db");

    private final String modelName;

    HexagonType(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}
