package com.example.cst438_project01_group11.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project01_group11.Database.Pokemon;
import com.example.cst438_project01_group11.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonRecyclerViewAdapter.PokemonViewHolder> {

    private ArrayList<Pokemon> mPokemonList;

    public PokemonRecyclerViewAdapter(ArrayList<Pokemon> pokemonList) {
        mPokemonList = pokemonList;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView mPokemonImage;
        public TextView mPokemonName;

        public PokemonViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mPokemonImage = itemView.findViewById(R.id.pokemon_card_image);
            mPokemonName = itemView.findViewById(R.id.pokemon_card_name);
        }
    }

    @NonNull
    @NotNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_card_layout, parent, false);
        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PokemonRecyclerViewAdapter.PokemonViewHolder holder, int position) {
        Pokemon currentItem = mPokemonList.get(position);
        holder.mPokemonImage.setImageResource(currentItem.getImage());
        holder.mPokemonName.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }
}
