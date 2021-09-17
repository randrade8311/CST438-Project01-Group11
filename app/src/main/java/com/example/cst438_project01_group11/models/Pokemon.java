package com.example.cst438_project01_group11.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.cst438_project01_group11.PokedexDatabase;

import java.util.List;

@Entity(tableName = PokedexDatabase.POKEMON_TABLE)
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int mPokemonId;

    private Integer id;
    private String name;
    private String type1;
    private String type2;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokemonId() {
        return mPokemonId;
    }

    public void setPokemonId(int mPokemonId) {
        this.mPokemonId = mPokemonId;
    }

    public Integer getId() {
        if (id == null) {
            String text = "https://pokeapi.co/api/v2/pokemon/";
            String s = url.substring(text.length(), url.length() - 1);
            id = Integer.parseInt(s);
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        if (id == null) {
            getId();
        }
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + id + ".png";
    }

    private void getTypeFromUrl() {
        type1 = "normal";
    }
}
