package com.example.cst438_project01_group11.models;

import com.google.gson.annotations.SerializedName;

public class PokemonType {
    @SerializedName("name")
    public String pokemonType;

    public PokemonType(String pokemonType){
        this.pokemonType = pokemonType;
    }

    public String getPokemonTypeName() {
        return pokemonType;
    }

    public void setPokemonTypeName(String pokemonType) {
        this.pokemonType = pokemonType;
    }
}
