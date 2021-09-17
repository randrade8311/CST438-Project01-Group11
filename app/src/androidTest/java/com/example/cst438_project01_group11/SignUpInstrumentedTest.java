package com.example.cst438_project01_group11;

import static com.example.cst438_project01_group11.CreateAccountActivity.validate;
import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.cst438_project01_group11.Database.PokedexDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class SignUpInstrumentedTest {
    private PokedexDatabase db;

    @Test
    public void emptyField() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "";
        String password = "test";

        assertEquals("empty fields", validate("Aundre", username, password, db));
    }

    @Test
    public void emptyFields() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "";
        String password = "";

        assertEquals("empty fields", validate("Rigo", username, password, db));
    }

    @Test
    public void usernameTaken() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "aj";
        String password = "test";

        assertEquals("username taken", validate("Aundre", username, password, db));
    }

    @Test
    public void validInfo() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        db = PokedexDatabase.getInstance(appContext);
        String username = "hello";
        String password = "new";

        assertEquals("valid", validate("Aundre", username, password, db));
    }
}
