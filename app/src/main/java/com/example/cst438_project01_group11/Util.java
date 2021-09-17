package com.example.cst438_project01_group11;

import android.content.Context;

import androidx.room.Room;

public class Util {
    public static PokemonDao getPokemonDatabase(Context context) {
        return Room.databaseBuilder(context, PokedexDatabase.class, PokedexDatabase.POKEMON_TABLE)
                .allowMainThreadQueries()
                .build()
                .getPokemonDao();
    }
}
