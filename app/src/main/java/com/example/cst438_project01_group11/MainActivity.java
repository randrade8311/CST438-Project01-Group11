package com.example.cst438_project01_group11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, new PokedexFragment())
            .commit();

        setBottomNavigationListener();
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