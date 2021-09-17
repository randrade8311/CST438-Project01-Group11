package com.example.cst438_project01_group11.pokiapi;

import com.example.cst438_project01_group11.models.PokemonResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokiapiService {

    @GET("pokemon")
    Call<PokemonResults> obtainListPokemon(@Query("limit") int limit, @Query("offset") int offset);

}
