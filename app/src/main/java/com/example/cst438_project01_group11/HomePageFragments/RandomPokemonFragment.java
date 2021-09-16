package com.example.cst438_project01_group11.HomePageFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cst438_project01_group11.PokemonTypes;
import com.example.cst438_project01_group11.R;
import com.example.cst438_project01_group11.models.Pokemon;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

public class RandomPokemonFragment extends Fragment {

    private Pokemon mPokemon;

    private ImageView mPokemonImage;
    private TextView mPokemonName;
    private TextView mType1;
    private TextView mType2;
    private MaterialCardView mCardEvo1;
    private ImageView mEvo1;
    private MaterialCardView mCardEvo2;
    private ImageView mEvo2;
    private MaterialButton mAddToTeam;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.random_pokemon_layout, container, false);
        findViews(view);
        setTypeColors();
        setPokemonName();
        return view;
    }

    private void setPokemonName() {
        mPokemonName.setText("Charizard");
    }

    private void setTypeColors() {
        mType1.setText(PokemonTypes.DRAGON.getType());
        mType1.setBackgroundColor(PokemonTypes.DRAGON.getColor());
        mType2.setText(PokemonTypes.FIRE.getType());
        mType2.setBackgroundColor(PokemonTypes.FIRE.getColor());
    }

    private void findViews(View view) {
        mPokemonImage = view.findViewById(R.id.pokemon_image);
        mPokemonName = view.findViewById(R.id.pokemon_name);
        mType1 = view.findViewById(R.id.pokemon_type_1_text);
        mType2 = view.findViewById(R.id.pokemon_type_2_text);
        mCardEvo1 = view.findViewById(R.id.pokemon_evolution_card_1);
        mEvo1 = view.findViewById(R.id.pokemon_evolution_1);
        mCardEvo2 = view.findViewById(R.id.pokemon_evolution_card_2);
        mEvo2 = view.findViewById(R.id.pokemon_evolution_2);
        mAddToTeam = view.findViewById(R.id.add_to_team_button);
        addListeners();
    }

    private void addListeners() {
        mAddToTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Added pokemon to team", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
