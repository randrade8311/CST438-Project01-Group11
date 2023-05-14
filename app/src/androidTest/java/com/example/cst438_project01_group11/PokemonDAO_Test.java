package com.example.cst438_project01_group11;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cst438_project01_group11.Database.PokedexDatabase;
import com.example.cst438_project01_group11.Database.PokemonDao;
import com.example.cst438_project01_group11.Database.UserDao;
import com.example.cst438_project01_group11.models.Pokemon;

import org.junit.Test;
import org.junit.runner.RunWith;

import static java.sql.Types.NULL;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PokemonDAO_Test {
    private PokedexDatabase db;

    @Test
    public void pokemonInsertTest() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        PokemonDao myTestDB = Room.databaseBuilder(appContext, PokedexDatabase.class, "pokedex.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getPokemonDao();

        Pokemon pokemon = new Pokemon("Arceus", "everything", "testing/url.png", 200);
        myTestDB.delete(pokemon);
        myTestDB.addPokemon(pokemon);
        Pokemon pokemon1 = myTestDB.getPokemonByName("Arceus");
        assertEquals(pokemon, pokemon1);
    }

    @Test
    public void emptyList() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        PokemonDao myTestDB = Room.databaseBuilder(appContext, PokedexDatabase.class, "pokedex.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getPokemonDao();
        Pokemon pokemon = new Pokemon("Arceus", "everything", "testing/url.png", 200);
        myTestDB.delete(pokemon);
        int prev = myTestDB.count();
        myTestDB.addPokemon(pokemon);
        assertEquals(myTestDB.count(), prev +1);
    }

    @Test
    public void deletePokemon() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        PokemonDao myTestDB = Room.databaseBuilder(appContext, PokedexDatabase.class, "pokedex.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getPokemonDao();

        Pokemon pokemon = new Pokemon("Arceus", "everything", "testing/url.png", 200);
        myTestDB.delete(pokemon);
        myTestDB.addPokemon(pokemon);

        assert(myTestDB.count() >= 1);
    }
}
