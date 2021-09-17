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

    public static int getColor(String type) {
        if (PokemonTypes.BUG.getType().equals(type.toLowerCase())) {
            return Color.parseColor(PokemonTypes.BUG.getColorString());
        } else if (PokemonTypes.NORMAL.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.NORMAL.getColorString());
        } else if (PokemonTypes.DARK.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.DARK.getColorString());
        } else if (PokemonTypes.DRAGON.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.DRAGON.getColorString());
        } else if (PokemonTypes.ELECTRIC.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.ELECTRIC.getColorString());
        } else if (PokemonTypes.FAIRY.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.FAIRY.getColorString());
        } else if (PokemonTypes.FIGHTING.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.FIGHTING.getColorString());
        } else if (PokemonTypes.FIRE.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.FIRE.getColorString());
        } else if (PokemonTypes.FLYING.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.FLYING.getColorString());
        } else if (PokemonTypes.GHOST.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.GHOST.getColorString());
        } else if (PokemonTypes.GRASS.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.GRASS.getColorString());
        } else if (PokemonTypes.GROUND.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.GROUND.getColorString());
        } else if (PokemonTypes.ICE.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.ICE.getColorString());
        } else if (PokemonTypes.POISON.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.POISON.getColorString());
        } else if (PokemonTypes.PSYCHIC.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.PSYCHIC.getColorString());
        } else if (PokemonTypes.ROCK.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.ROCK.getColorString());
        } else if (PokemonTypes.STEEL.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.STEEL.getColorString());
        } else if (PokemonTypes.WATER.getType().equals(type)) {
            return Color.parseColor(PokemonTypes.WATER.getColorString());
        } else {
            return Color.parseColor("#000000");
        }

    }

    public String getColorString() {
        return color;
    }
}
