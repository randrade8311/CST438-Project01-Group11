package com.example.cst438_project01_group11.HomePageFragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project01_group11.Adapters.PokemonDialog;
import com.example.cst438_project01_group11.Adapters.PokemonRecyclerViewAdapter;
import com.example.cst438_project01_group11.R;
import com.example.cst438_project01_group11.models.Pokemon;

import java.util.ArrayList;


public class PokedexFragment extends Fragment {

    private PokedexFragmentInterface mInterface;
    private EditText mSearch;
    private RecyclerView mPokemonsView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PokemonRecyclerViewAdapter mAdapter;

    private ArrayList<Pokemon> mPokemons;

    public interface PokedexFragmentInterface {
        ArrayList<Pokemon> getPokemons();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pokedex_layout, container, false);
        mPokemons = mInterface.getPokemons();
        mSearch = view.findViewById(R.id.home_page_pokemon_search_edittext);
        addListeners();
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


    private void generateRecyclerView(View view, ArrayList<Pokemon> pokemonList) {
        mPokemonsView = view.findViewById(R.id.pokedex_recycler_view);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mAdapter = new PokemonRecyclerViewAdapter(pokemonList, getContext());
        mPokemonsView.setLayoutManager(mLayoutManager);
        mPokemonsView.setAdapter(mAdapter);

        mAdapter.setPokemonListener(position -> {
            alertDialog(mPokemons.get(position));
        });
    }

    private void alertDialog(Pokemon pokemon) {
        PokemonDialog pokemonDialog = new PokemonDialog(pokemon);
        pokemonDialog.setCancelable(true);
        pokemonDialog.show(getParentFragmentManager(), null);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof PokedexFragmentInterface) {
            mInterface = (PokedexFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement PokedexFragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mInterface = null;
    }
}
