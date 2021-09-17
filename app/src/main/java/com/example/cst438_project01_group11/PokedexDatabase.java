package com.example.cst438_project01_group11;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cst438_project01_group11.models.Pokemon;

@Database(entities = {DreamTeam.class, User.class, Pokemon.class}, version = 2, exportSchema = false)
import java.util.List;

@Database(entities = {DreamTeam.class, User.class}, version = 1, exportSchema = false)
public abstract class PokedexDatabase extends RoomDatabase {
    public static final String POKEMON_TABLE = "POKEMON_TABLE";

    private static PokedexDatabase sInstance;
    public abstract DreamTeamDao dreamTeam();
    public abstract UserDao user();
    public abstract PokemonDao getPokemonDao();

    public static synchronized PokedexDatabase getInstance(Context context){
        if (sInstance == null){
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(),
                            PokedexDatabase.class,
                            "pokedex.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void printUsers() {
        List<User> users = user().getAll();
        Log.i("DB", String.valueOf(user().count()));
        for(int i = 0; i < user().count(); i++) {
            Log.i("DB", users.get(i).toString());
        }
    }
}
