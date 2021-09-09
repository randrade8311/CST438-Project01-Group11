package com.example.cst438_project01_group11;

public enum PokemonTypes {
    BUG("bug", "A8B820"),
    NORMAL("normal", "A8A878");

    private final String type;
    private final String color;

    PokemonTypes(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
}
