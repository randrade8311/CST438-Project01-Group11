package com.example.cst438_project01_group11.models;

import com.google.gson.annotations.SerializedName;

public class PokemonTypes {
    @SerializedName("type")
    private PokemonType pokemonType;

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }
}
