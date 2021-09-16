package com.example.cst438_project01_group11;

import android.content.res.ColorStateList;
import android.graphics.Color;

public enum PokemonTypes {
    BUG("bug", "#A8B820"),
    NORMAL("normal", "#A8A878"),
    DARK("dark", "#705848"),
    DRAGON("dragon", "#7038F8"),
    ELECTRIC("electric", "#F8D030"),
    FAIRY("fairy", "#EE99AC"),
    FIGHTING("fighting", "#C03028"),
    FIRE("fire", "#F08030"),
    FLYING("flying", "#A890F0"),
    GHOST("ghost", "#705898"),
    GRASS("grass", "#78C850"),
    GROUND("ground", "#E0C068"),
    ICE("ice", "#98D8D8"),
    POISON("poison", "#A040A0"),
    PSYCHIC("psychic", "#F85888"),
    ROCK("rock", "#B8A038"),
    STEEL("steel", "#B8B8D0"),
    WATER("water", "#6890F0");

    private final String type;
    private final String color;

    PokemonTypes(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public int getColor() {
        return Color.parseColor(color);
    }

    public String getColorString() {
        return color;
    }
}
