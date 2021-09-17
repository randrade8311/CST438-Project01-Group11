package com.example.cst438_project01_group11.models;

import com.google.gson.annotations.SerializedName;

public class PokemonSprites {
    @SerializedName("front_default")
    private String url;

    public PokemonSprites(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
