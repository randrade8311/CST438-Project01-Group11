package com.example.cst438_project01_group11.Adapters;

import android.content.Context;
import android.util.Log;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class PokemonRecyclerViewAdapter extends RecyclerView.Adapter<PokemonRecyclerViewAdapter.PokemonViewHolder> {

    private List<Pokemon> mPokemonList;
    private PokemonClickListener mListener;
    private Context context;

    public PokemonRecyclerViewAdapter(List<Pokemon> pokemonList, Context context) {
        mPokemonList = pokemonList;
        this.context = context;
    }

    public interface PokemonClickListener {
        void onItemClick(int position);
    }

    public void setPokemonListener(PokemonClickListener listener) {
        mListener = listener;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView mPokemonImage;
        public TextView mPokemonName;

        public PokemonViewHolder(@NonNull @NotNull View itemView, PokemonClickListener listener) {
            super(itemView);
            mPokemonImage = itemView.findViewById(R.id.pokemon_card_image);
            mPokemonName = itemView.findViewById(R.id.pokemon_card_name);

            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    @NonNull
    @NotNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_card_layout, parent, false);
        return new PokemonViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PokemonRecyclerViewAdapter.PokemonViewHolder holder, int position) {
        Pokemon currentItem = mPokemonList.get(position);
        Glide.with(context)
                .load(currentItem.getUrl())
                .centerCrop()
                .placeholder(R.drawable.pokeball_icon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mPokemonImage);
        holder.mPokemonName.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        if (mPokemonList != null)
            return mPokemonList.size();
        else
            Log.e("ADAPTER", "Null ArrayList");
        return 0;
    }

    public void filterList(List<Pokemon> filteredPokemons) {
        mPokemonList = filteredPokemons;
        notifyDataSetChanged();
    }
}