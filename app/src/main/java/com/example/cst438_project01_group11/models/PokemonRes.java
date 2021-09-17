package com.example.cst438_project01_group11.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonRes {
    @SerializedName("results")
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
