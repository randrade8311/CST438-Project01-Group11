package com.example.cst438_project01_group11.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.cst438_project01_group11.Database.PokedexDatabase;

import java.util.Objects;

@Entity(tableName = PokedexDatabase.POKEMON_TABLE)
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private int mPokemonId;

    private Integer id;
    private String name;
    private String type1;
    private String url;

    public Pokemon(String name, String type1, String url, int id) {
        this.name = name;
        this.type1 = type1;
        this.url = url;
        this.id = id;
    }

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
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png";
    }

    public String getHighResImage() {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + id + ".png";
    }

    private void getTypeFromUrl() {
        type1 = "normal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return name.equals(pokemon.name) &&
                Objects.equals(type1, pokemon.type1) &&
                Objects.equals(url, pokemon.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type1, url);
    }
}
