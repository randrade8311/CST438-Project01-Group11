package com.example.cst438_project01_group11.pokiapi;

import com.example.cst438_project01_group11.models.PokemonRes;

public interface PokiapiService {

    @GET("pokemon")
    Call<PokemonRes> obtenerListaPokemon();


}
