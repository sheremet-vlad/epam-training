package com.epam.training.tasks.task3.enumeration;

public enum FlowerEnum  {
    ORIGIN("origin"),
    SOIL("soil"),
    NAME("name"),
    VISUAL_PARAMETR("visual_parametr"),
    STEM_COLOR("stem_color"),
    SHEET_COLOR("sheet_color"),
    AVERAGE_SIZE("average_size"),
    DIGESTION_IN_SECONDS("digestion_in_seconds"),
    FLOWER("flower"),
    CARNIVOROUS_FLOWR("carnivorous_flower"),
    FLOWERS("flowers");

    private String value;

    FlowerEnum(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
