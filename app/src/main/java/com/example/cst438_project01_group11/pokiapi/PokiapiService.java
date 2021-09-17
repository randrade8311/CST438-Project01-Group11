package com.example.cst438_project01_group11.pokiapi;
import com.example.cst438_project01_group11.models.PokemonRes;
import com.example.cst438_project01_group11.models.PokemonSpritesRes;
import com.example.cst438_project01_group11.models.PokemonTypeRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokiapiService {

    @GET("pokemon")
    Call<PokemonRes> obtainListPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{name}")
    Call<PokemonSpritesRes> getPokemonSprite(@Path("name") String pokemonName);

    @GET("pokemon/{name}")
    Call<PokemonTypeRes> getPokemonType(@Path("name") String pokemonName);

}
