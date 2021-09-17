package com.example.cst438_project01_group11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cst438_project01_group11.HomePageFragments.PokedexFragment;
import com.example.cst438_project01_group11.HomePageFragments.RandomPokemonFragment;
import com.example.cst438_project01_group11.HomePageFragments.TeamFragment;
import com.example.cst438_project01_group11.models.PokemonSprites;
import com.example.cst438_project01_group11.models.PokemonSpritesRes;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import com.example.cst438_project01_group11.models.Pokemon;
import com.example.cst438_project01_group11.models.PokemonRes;
import com.example.cst438_project01_group11.pokiapi.PokiapiService;

import org.chromium.base.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKIDEX";

    private BottomNavigationView mBottomNavigationView;
    private int mFragmentId;
    private PokedexDatabase pokedexDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomNavigationView();
        pokedexDatabase = PokedexDatabase.getInstance(this);
        pokedexDatabase.addPokemon();
    }

    private void initBottomNavigationView() {
        mFragmentId = R.id.pokedex_navigation;
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        Fragment selectedFragment;
        if(mFragmentId == R.id.pokedex_navigation) {
            selectedFragment = new PokedexFragment();
        } else if (mFragmentId == R.id.poketeam_navigation) {
            selectedFragment = new TeamFragment();
        } else if (mFragmentId == R.id.random_pokemon_navigation) {
            selectedFragment = new RandomPokemonFragment();
        } else {
            selectedFragment = new PokedexFragment();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();

        setBottomNavigationListener();
    }

    private void setBottomNavigationListener() {
        mBottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                Fragment selectedFragment;
                mFragmentId = item.getItemId();

                if(mFragmentId == R.id.pokedex_navigation) {
                    selectedFragment = new PokedexFragment();
                } else if (mFragmentId == R.id.poketeam_navigation) {
                    selectedFragment = new TeamFragment();
                } else if( mFragmentId == R.id.random_pokemon_navigation) {
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