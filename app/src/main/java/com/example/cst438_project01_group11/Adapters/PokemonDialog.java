package com.example.cst438_project01_group11.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cst438_project01_group11.PokemonTypes;
import com.example.cst438_project01_group11.R;
import com.example.cst438_project01_group11.models.Pokemon;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class PokemonDialog extends DialogFragment {

    private ImageView mPokemonImage;
    private TextView mPokemonName;
    private TextView mType1;
    private TextView mType2;
    private MaterialButton mAddToTeam;
    private MaterialButton mRemoveFromTeam;
    private MaterialCardView mCardt1;
    private MaterialCardView mCardt2;

    private Pokemon mPokemon;

    public PokemonDialog(Pokemon pokemon) {
        super();
        mPokemon = pokemon;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.pokemon_layout, null);
        mPokemonImage = view.findViewById(R.id.pokemon_image);
        mPokemonName = view.findViewById(R.id.pokemon_name);
        mType1 = view.findViewById(R.id.pokemon_type_1_text);
        mType2 = view.findViewById(R.id.pokemon_type_2_text);
        mAddToTeam = view.findViewById(R.id.add_to_team_button);
        mRemoveFromTeam = view.findViewById(R.id.remove_from_team_button);
        mCardt1 = view.findViewById(R.id.pokemon_card_type1);
        mCardt2 = view.findViewById(R.id.pokemon_card_type2);
        setInformation();
        builder.setView(view);
        return builder.create();
    }

    private void setInformation() {
        Glide.with(getContext())
                .load(mPokemon.getHighResImage())
                .centerCrop()
                .placeholder(R.drawable.pokeball_icon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mPokemonImage);
        mPokemonName.setText(mPokemon.getName());

        if (mPokemon.getType1() != null) {
            mType1.setText(mPokemon.getType1());
            mType1.setBackgroundColor(PokemonTypes.getColor(mPokemon.getType1()));
        } else {
            mType1.setVisibility(View.GONE);
        }
        mType2.setVisibility(View.GONE);
        mCardt2.setVisibility(View.GONE);
//        if (mPokemon.getType2() != null) {
//            mType2.setText(mPokemon.getType2());
//            mType2.setBackgroundColor(PokemonTypes.getColor(mPokemon.getType2()));
//        } else {
//            mType2.setVisibility(View.GONE);
//        }

        mAddToTeam.setOnClickListener(view -> {
            //TODO
        });

        mRemoveFromTeam.setOnClickListener(view -> {
            //TODO
        });
    }
}
