package com.example.cst438_project01_group11;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cst438_project01_group11.HomePageFragments.PokedexFragment;
import com.example.cst438_project01_group11.HomePageFragments.RandomPokemonFragment;
import com.example.cst438_project01_group11.HomePageFragments.TeamFragment;
import com.example.cst438_project01_group11.models.Pokemon;
import com.example.cst438_project01_group11.models.PokemonResults;
import com.example.cst438_project01_group11.pokiapi.PokiapiService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements PokedexFragment.PokedexFragmentInterface, RandomPokemonFragment.RandomFragmentInterface, TeamFragment.TeamFragmentInterface {

    //List to store results from PokeApi and Database
    private List<Pokemon> mPokemons = new ArrayList<>();
    private static final String TAG = "POKEDEX";

    //Bottom Navigation switch between the three fragments
    private BottomNavigationView mBottomNavigationView;
    private int mFragmentId;
    private PokemonDao mPokemonDao;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createBottomNavigationView();
        setUser();
        mPokemonDao = PokedexDatabase.getInstance(getApplicationContext()).getPokemonDao();
        if (mPokemonDao.getAllPokemons().size() <= 0) {
            obtainData();
        } else {
            mPokemons = mPokemonDao.getAllPokemons();
        }

    }


    //Get user from intent, if no user present in intent start Login Activity
    private void setUser() {
        String username = getIntent().getStringExtra(LoginActivity.USERNAME);
        if(username == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putExtra(LoginActivity.USERNAME, "");
            startActivity(intent);
        }
        mUser = PokedexDatabase.getInstance(getApplicationContext()).user().findByUsername(username);
    }

    //Initialize bottom navigation to make switching between fragments possible
    private void createBottomNavigationView() {
        mFragmentId = R.id.pokedex_navigation;
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        Fragment selectedFragment = new PokedexFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();

        setBottomNavigationListener();
    }

    //Pull pokemon data from PokeApi
    private void obtainData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokiapiService service = retrofit.create(PokiapiService.class);
        Call<PokemonResults> pokemonResCall = service.obtainListPokemon(250, 0);

        pokemonResCall.enqueue(new Callback<PokemonResults>() {
            @Override
            public void onResponse(@NonNull Call<PokemonResults> call, @NonNull Response<PokemonResults> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.error_code) + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                PokemonResults pokemonResults = response.body();
                assert pokemonResults != null;
                mPokemons = pokemonResults.getResults();
                for (Pokemon p : mPokemons) {
                    mPokemonDao.addPokemon(p);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PokemonResults> call, @NonNull Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }

    //Set Navigation Listener to switch between fragments when clicked
    private void setBottomNavigationListener() {
        mBottomNavigationView.setOnItemSelectedListener(item -> {

            Fragment selectedFragment;
            mFragmentId = item.getItemId();

            if (mFragmentId == R.id.pokedex_navigation) {
                selectedFragment = new PokedexFragment();
            } else if (mFragmentId == R.id.poketeam_navigation) {
                selectedFragment = new TeamFragment();
            } else if (mFragmentId == R.id.random_pokemon_navigation) {
                selectedFragment = new RandomPokemonFragment();
            } else {
                return false;
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        });
    }

    //Return pokemon list to fragments
    @Override
    public List<Pokemon> getPokemons() {
        return mPokemons;
    }

    //Return team to Team Fragment
    @Override
    public ArrayList<Pokemon> getTeam() {
        ArrayList<Pokemon> team = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            team.add(mPokemons.get(random.nextInt(mPokemons.size())));
        }
        return team;
    }

    //Return user to fragments
    @Override
    public User getUser() {
        return mUser;
    }
}