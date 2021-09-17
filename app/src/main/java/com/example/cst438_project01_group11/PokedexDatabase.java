package com.example.cst438_project01_group11;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cst438_project01_group11.models.Pokemon;
import com.example.cst438_project01_group11.models.PokemonRes;
import com.example.cst438_project01_group11.models.PokemonSprites;
import com.example.cst438_project01_group11.models.PokemonSpritesRes;
import com.example.cst438_project01_group11.models.PokemonType;
import com.example.cst438_project01_group11.models.PokemonTypeRes;
import com.example.cst438_project01_group11.models.PokemonTypes;
import com.example.cst438_project01_group11.pokiapi.PokiapiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Database(entities = {DreamTeam.class, User.class, Pokemon.class}, version = 16, exportSchema = false)
public abstract class PokedexDatabase extends RoomDatabase {
    private static PokedexDatabase sInstance;
    public abstract DreamTeamDao dreamTeam();
    public abstract UserDao user();
    public abstract PokemonDao pokemon();

    List<Pokemon> pokemonList;
    private String type;
    private String imgURL;
    Pokemon pokemon;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
               .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static synchronized PokedexDatabase getInstance(Context context){
        if (sInstance == null){
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(),
                            PokedexDatabase.class,
                            "pokedex.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void printUsers() {
        List<User> users = user().getAll();
        for (int i = 0; i < user().count(); i++) {
            Log.i("DB", users.get(i).toString());
        }
    }

    public void addPokemon() {
        if (pokemon().count() == 0){
            getPokemon();
        }
        pokemonList = pokemon().getAllPokemon();
        for (int i = 0; i < pokemonList.size(); i++) {
            Log.i("TAG", pokemonList.get(i).toString());
        }
    }

    public void savePokemonList(List<Pokemon> pList) {
        pokemonList = pList;
        for (int i = 0; i < pokemonList.size(); i++) {
            pokemonList.get(i).setId(i+1);
            pokemon().addPokemon(pokemonList.get(i));
            getPokemonUrlImg(pokemonList.get(i).getName(), i+1);
            getPokemonType(pokemonList.get(i).getName(), i+1);
        }
    }

    public void getPokemonUrlImg(String name, int id){
        PokiapiService service = retrofit.create(PokiapiService.class);
        Call<PokemonSpritesRes> pokemonSpritesCall = service.getPokemonSprite(name);

        pokemonSpritesCall.enqueue(new retrofit2.Callback<PokemonSpritesRes>() {
            @Override
            public void onResponse(Call<PokemonSpritesRes> call, Response<PokemonSpritesRes> response) {
                PokemonSprites pokemonSprites = response.body().getSprite();
                pokemon = pokemon().getPokemon(id);
                pokemon.setUrl(pokemonSprites.getUrl());
                pokemon().update(pokemon);
            }

            @Override
            public void onFailure(Call<PokemonSpritesRes> call, Throwable t) {
                Log.e("TAG", t.toString());
            }
        });
    }

    public void getPokemonType(String name, int id){
        PokiapiService service1 = retrofit.create(PokiapiService.class);
        Call<PokemonTypeRes> pokemonTypeResCall = service1.getPokemonType(name);
        pokemonTypeResCall.enqueue(new retrofit2.Callback<PokemonTypeRes>() {
            @Override
            public void onResponse(Call<PokemonTypeRes> call, Response<PokemonTypeRes> response) {
                String pokemonType = response.body().getPokemonTypes().get(0).getPokemonType().getPokemonTypeName();
                pokemon = pokemon().getPokemon(id);
                pokemon.setType(pokemonType);
                pokemon().update(pokemon);
            }

            @Override
            public void onFailure(Call<PokemonTypeRes> call, Throwable t) {
                Log.e("TAG", t.toString());
            }
        });
    }

    public void getPokemon() {
        PokiapiService service = retrofit.create(PokiapiService.class);
        Call<PokemonRes> pokemonSpritesResCall = service.obtainListPokemon(50, 0);
        pokemonSpritesResCall.enqueue(new retrofit2.Callback<PokemonRes>() {
            @Override
            public void onResponse(Call<PokemonRes> call, Response<PokemonRes> response) {
                List<Pokemon> pokemonList = response.body().getResults();
                savePokemonList(pokemonList);
            }

            @Override
            public void onFailure(Call<PokemonRes> call, Throwable t) {

            }
        });
    }
}
