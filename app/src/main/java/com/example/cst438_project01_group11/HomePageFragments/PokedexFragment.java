package com.example.cst438_project01_group11.HomePageFragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project01_group11.Adapters.PokemonRecyclerViewAdapter;
import com.example.cst438_project01_group11.models.Pokemon;
import com.example.cst438_project01_group11.PokedexDatabase;
import com.example.cst438_project01_group11.R;

import java.util.ArrayList;
import java.util.List;

public class PokedexFragment extends Fragment {

    private EditText mSearch;
    private RecyclerView mPokemonsView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PokemonRecyclerViewAdapter mAdapter;

    private List<Pokemon> mPokemons;

    PokedexDatabase pokedexDatabase;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout. pokedex_layout, container, false);
        pokedexDatabase = PokedexDatabase.getInstance(getContext());
        mSearch = view.findViewById(R.id.home_page_pokemon_search_edittext);
        addListeners();
        mPokemons = getPokemonList();
        generateRecyclerView(view, mPokemons);
        return view;
    }

    private void addListeners() {
        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (Pokemon p : mPokemons) {
            if (p.getName().toLowerCase().contains(text.toLowerCase())) {
                pokemons.add(p);
            }
        }
        mAdapter.filterList(pokemons);
    }

    private List<Pokemon> getPokemonList() {
        List<Pokemon> list = pokedexDatabase.pokemon().getAllPokemon();
        return list;
    }

    private void generateRecyclerView(View view, List<Pokemon> pokemonList) {
        mPokemonsView = view.findViewById(R.id.pokedex_recycler_view);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mAdapter = new PokemonRecyclerViewAdapter(pokemonList, getContext());
        mPokemonsView.setLayoutManager(mLayoutManager);
        mPokemonsView.setAdapter(mAdapter);

    }
}
