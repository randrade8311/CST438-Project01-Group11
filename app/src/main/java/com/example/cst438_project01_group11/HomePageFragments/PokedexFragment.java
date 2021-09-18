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
import com.example.cst438_project01_group11.User;
import com.example.cst438_project01_group11.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokedexFragment extends Fragment {

    private PokedexFragmentInterface mInterface;
    private EditText mSearch;
    private RecyclerView mPokemonsView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PokemonRecyclerViewAdapter mAdapter;

    private List<Pokemon> mPokemons;
    private User mUser;

    //Interface to access data from MainActivity
    public interface PokedexFragmentInterface {
        List<Pokemon> getPokemons();
        User getUser();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pokedex_layout, container, false);
        mPokemons = mInterface.getPokemons();
        mUser = mInterface.getUser();
        mSearch = view.findViewById(R.id.home_page_pokemon_search_edittext);
        addSearchListener();
        generateRecyclerView(view, mPokemons);
        return view;
    }

    //Add edit text listener for searching the pokemon list using pokemon name
    private void addSearchListener() {
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

    /**
     * This function takes search input from User and updates the results present in the
     * Recycler View.
     * @param text to get search text input
     */
    private void filter(String text) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (Pokemon p : mPokemons) {
            if (p.getName().toLowerCase().contains(text.toLowerCase())) {
                pokemons.add(p);
            }
        }
        mAdapter.filterList(pokemons);
    }

    /**
     * This function takes current view and list of pokemon to populate the Recycler
     * view.
     * @param view Current view to find and populate the recycler view
     * @param pokemonList List to populate recycler view content
     */
    private void generateRecyclerView(View view, List<Pokemon> pokemonList) {
        mPokemonsView = view.findViewById(R.id.pokedex_recycler_view);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mAdapter = new PokemonRecyclerViewAdapter(pokemonList, getContext());
        mPokemonsView.setLayoutManager(mLayoutManager);
        mPokemonsView.setAdapter(mAdapter);

        mAdapter.setPokemonListener(position -> alertDialog(mPokemons.get(position)));
    }

    /**
     * This function takes a pokemon and generates an alert Dialog with Pokemon
     * information.
     * @param pokemon Pokemon that shows up in the dialog.
     */
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
