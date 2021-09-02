package com.example.cst438_project01_group11;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cst438_project01_group11.HomePageFragments.PokedexFragment;
import com.example.cst438_project01_group11.HomePageFragments.RandomPokemonFragment;
import com.example.cst438_project01_group11.HomePageFragments.TeamFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

//    private Retrofit retrofit;
    private static final String TAG = "POKIDEX";

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomNavigationView();

//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://pokeapi.co/api/v2/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        obtenerDatos();
    }

    private void initBottomNavigationView() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new PokedexFragment())
                .commit();

        setBottomNavigationListener();
    }

    private void obtenerDatos(){
//        PokeapiService service =retrofit.create(PokeapiService.class);
//        Call<PokemonRes> pokemonResCall = service.obtenerListaPokemon();
//
//        pokemonResCall.enqueue(new Callback<PokemonRes>()){
//            @Override
//            public void onResponse(Call<PokemonRes> call, Response<PokemonRes> response) {
//                if (response.isSuccessful()){
//                    PokemonRes pokemonRes = response.body();
//                    ArrayList<Pokemon> listaPokemon = pokemonRes.getResults();
//
//                    for(int i = 0; i < listaPokemon.size(); i++){
//                        Pokemon p = listaPokemon.get(i);
//                        Log.i(TAG, " Pokemon: " + p.getName());
//                    }
//                } else {
//                    Log.e(TAG, " onResponse: " + response.errorBody());
//                }
//            }
//            @Override
//            public void onFailure(Call<PokemonRes> call, Throwable t){
//                Log.e(TAG, " onFailure: " + t.getMessage())
//            }
//        });


    }

    private void setBottomNavigationListener() {
        mBottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                Fragment selectedFragment;

                if(item.getItemId() == R.id.pokedex_navigation) {
                    selectedFragment = new PokedexFragment();
                } else if ( item.getItemId() == R.id.poketeam_navigation) {
                    selectedFragment = new TeamFragment();
                } else if( item.getItemId() == R.id.random_pokemon_navigation) {
                    selectedFragment = new RandomPokemonFragment();
                } else {
                    return false;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            }
        });
    }

}