package com.example.cst438_project01_group11.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.cst438_project01_group11.R;
import com.example.cst438_project01_group11.models.Pokemon;

import java.util.ArrayList;

public class DreamTeamRVAdapter extends RecyclerView.Adapter<DreamTeamRVAdapter.DreamTeamViewHolder> {
    private ArrayList<Pokemon> pokemonArrayList;
    private Context context;

    public DreamTeamRVAdapter(ArrayList<Pokemon> pokemonArrayList, Context context) {
        this.pokemonArrayList = pokemonArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DreamTeamRVAdapter.DreamTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_card_layout, parent, false);
        return new DreamTeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DreamTeamRVAdapter.DreamTeamViewHolder holder, int position) {
        Pokemon currentPokemon = pokemonArrayList.get(position);
        holder.pokemonName.setText(currentPokemon.getName());
        Glide.with(context)
                .load(currentPokemon.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.pokeball_icon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.pokemonImg);
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
