package com.example.cst438_project01_group11.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonTypeRes {
    @SerializedName("types")
    public List<PokemonTypes> pokemonTypesList;

    public List<PokemonTypes> getPokemonTypes() {
        return pokemonTypesList;
    }

    public void setPokemonTypes(List<PokemonTypes> pokemonTypesList) {
        this.pokemonTypesList = pokemonTypesList;
    }
}
