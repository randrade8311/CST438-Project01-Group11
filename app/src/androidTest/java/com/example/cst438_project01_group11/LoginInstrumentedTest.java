package com.example.cst438_project01_group11;

import static com.example.cst438_project01_group11.LoginActivity.validateUser;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import static org.junit.Assert.assertEquals;

import com.example.cst438_project01_group11.Database.PokedexDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {
    private PokedexDatabase db;

    @Test
    public void validUser() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "aj";
        String password = "test";

        assertEquals("valid", validateUser(username, password, db));
    }

    @Test
    public void wrongPassword() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "aje";
        String password = "test";

        assertEquals("wrong username", validateUser(username, password, db));
    }

    @Test
    public void wrongUsername() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "aj";
        String password = "testssss";

        assertEquals("wrong password", validateUser(username, password, db));
    }
}
