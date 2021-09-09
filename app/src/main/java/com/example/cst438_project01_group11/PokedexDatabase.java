package com.example.cst438_project01_group11;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DreamTeam.class, User.class}, version = 2, exportSchema = false)
public abstract class PokedexDatabase extends RoomDatabase {
    private static PokedexDatabase sInstance;
    public abstract DreamTeamDao dreamTeam();
    public abstract UserDao user();

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
}
