package com.example.cst438_project01_group11;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project01_group11.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDao {
    @Insert
    void addPokemon(Pokemon pokemon);

    @Query("SELECT COUNT(*) FROM pokemon")
    int count();

    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAllPokemon();

    @Query("SELECT * FROM pokemon WHERE id is :id")
    Pokemon getPokemon(int id);

    @Insert
    void addPokemon(Pokemon pokemon);

    @Query("SELECT COUNT(*) FROM " + PokedexDatabase.POKEMON_TABLE)
    int count();

    @Query("SELECT * FROM " + PokedexDatabase.POKEMON_TABLE)
    List<Pokemon> getAllPokemons();

    @Update
    void update(Pokemon pokemon);

    @Delete
    void delete(Pokemon pokemon);

    @Query("DELETE FROM pokemon")
    public void nukeTable();
}
