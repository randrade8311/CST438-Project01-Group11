package com.example.cst438_project01_group11.models;

import com.google.gson.annotations.SerializedName;

public class PokemonSpritesRes {
    @SerializedName("sprites")
    public PokemonSprites pokemonSprites;

    public PokemonSprites getSprite() {
        return pokemonSprites;
    }

    public void setResults(PokemonSprites pokemonSprites) {
        this.pokemonSprites = pokemonSprites;
    }
}