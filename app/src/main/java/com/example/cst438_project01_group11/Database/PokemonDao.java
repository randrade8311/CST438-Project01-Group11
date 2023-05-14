package com.example.cst438_project01_group11.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project01_group11.models.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

    @Insert
    void addPokemon(Pokemon pokemon);

    @Query("SELECT COUNT(*) FROM " + PokedexDatabase.POKEMON_TABLE)
    int count();

    @Query("SELECT * FROM " + PokedexDatabase.POKEMON_TABLE)
    List<Pokemon> getAllPokemons();

    @Query("SELECT * FROM " + PokedexDatabase.POKEMON_TABLE +" WHERE id is :id")
    Pokemon getPokemon(int id);

    @Query("SELECT * FROM " + PokedexDatabase.POKEMON_TABLE + " WHERE name is :name")
    Pokemon getPokemonByName(String name);

    @Update
    void update(Pokemon pokemon);

    @Delete
    void delete(Pokemon pokemon);

    @Query("DELETE FROM " + PokedexDatabase.POKEMON_TABLE)
    void nukeTable();
}
