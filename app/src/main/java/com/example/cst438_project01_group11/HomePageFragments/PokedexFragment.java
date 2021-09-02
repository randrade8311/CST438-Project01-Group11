package com.example.cst438_project01_group11.HomePageFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project01_group11.Adapters.PokemonRecyclerViewAdapter;
import com.example.cst438_project01_group11.Database.Pokemon;
import com.example.cst438_project01_group11.R;

import java.util.ArrayList;

public class PokedexFragment extends Fragment {


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pokedex_layout, container, false);

        ArrayList<Pokemon> pokemonList = getPokemonList();
        generateRecyclerView(view, pokemonList);
        return view;
    }

    private ArrayList<Pokemon> getPokemonList() {
        ArrayList<Pokemon> list = new ArrayList<>();
        for(int i=0; i<50; i++) {
            list.add(new Pokemon(i, R.drawable.broken_image, "Pokemon "+i));
        }
        return list;
    }

    private void generateRecyclerView(View view, ArrayList<Pokemon> pokemonList) {
        RecyclerView mPokemons = view.findViewById(R.id.pokedex_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        PokemonRecyclerViewAdapter mAdapter = new PokemonRecyclerViewAdapter(pokemonList);
        mPokemons.setLayoutManager(mLayoutManager);
        mPokemons.setAdapter(mAdapter);
    }
}
