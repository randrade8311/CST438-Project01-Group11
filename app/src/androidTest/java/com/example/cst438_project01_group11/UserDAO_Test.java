package com.example.cst438_project01_group11;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cst438_project01_group11.Database.PokedexDatabase;
import com.example.cst438_project01_group11.Database.UserDao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserDAO_Test {
    private PokedexDatabase db;

    @Test
    public void userInsertTest() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDao myTestDB = Room.databaseBuilder(appContext, PokedexDatabase.class, "pokedex.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getUserDAO();

        User user = new User("Rodrigo", "rigo", "password01");

        int prev = myTestDB.count();
        myTestDB.delete(user);
        myTestDB.addUser(user);

        assertEquals(myTestDB.count(), prev+1);
    }

    @Test
    public void usersNotEmpty() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDao myTestDB = Room.databaseBuilder(appContext, PokedexDatabase.class, "pokedex.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getUserDAO();

        User user = new User("Rodrigo", "rigo", "password01");

        myTestDB.delete(user);
        if (myTestDB.findByUsername(user.getUUsername()).equals(null)){
            myTestDB.addUser(user);
        }

        assert(myTestDB.count() >= 1);
    }

    @Test
    public void userFindById(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDao myTestDB = Room.databaseBuilder(appContext, PokedexDatabase.class, "pokedex.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getUserDAO();

        User user2 = new User("Rodrigo", "rigo2", "password02");

        myTestDB.addUser(user2);

        User user3 = myTestDB.findByUsername(user2.getUUsername());

        assertEquals(user2, user3);

    }
}
