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

public class DreamTeamRVAdapter extends RecyclerView.Adapter<DreamTeamRVAdapter.DreamTeamViewHolder> {
    private ArrayList<Pokemon> pokemonArrayList;

    public DreamTeamRVAdapter(ArrayList<Pokemon> pokemonArrayList){
        this.pokemonArrayList = pokemonArrayList;
    }

    @NonNull
    @Override
    public DreamTeamRVAdapter.DreamTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_layout, parent, false);
        return new DreamTeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DreamTeamRVAdapter.DreamTeamViewHolder holder, int position) {
        Pokemon currentPokemon = pokemonArrayList.get(position);
        holder.pokemonName.setText(currentPokemon.getName());
        holder.pokemonImg.setImageResource(currentPokemon.getImage());
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

    public static class DreamTeamViewHolder extends RecyclerView.ViewHolder {
        public ImageView pokemonImg;
        public TextView pokemonName;

        public DreamTeamViewHolder(@NonNull View itemView) {
            super(itemView);
            // find view by id
            pokemonImg = itemView.findViewById(R.id.pokemonDT);
            pokemonName = itemView.findViewById(R.id.pokemonNameDT);
        }
    }
}
//
//    public void filterList(ArrayList<Pokemon> filteredPokemons) {
//        mPokemonList = filteredPokemons;
//        notifyDataSetChanged();
//    }
//}
