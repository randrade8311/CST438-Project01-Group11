package com.example.cst438_project01_group11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateAccountActivity extends AppCompatActivity {
    private PokedexDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        db = PokedexDatabase.getInstance(this);

        Button submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(c -> {
            // Input Values
            EditText name1 = findViewById(R.id.name);
            EditText username1 = findViewById(R.id.username);
            EditText password1 = findViewById(R.id.password);
            String name = name1.getText().toString();
            String username = username1.getText().toString();
            String password = password1.getText().toString();

            String res = validate(name, username, password, db);
            switch (res) {
                case "valid":
                    User user = new User(name, username, password);
                    db.user().addUser(user);
                    Toast.makeText(CreateAccountActivity.this, "Account created!", Toast.LENGTH_LONG).show();
                    break;
                case "username taken":
                    Toast.makeText(CreateAccountActivity.this, "Username is already taken.", Toast.LENGTH_LONG).show();
                    return;
                case "empty fields":
                    Toast.makeText(CreateAccountActivity.this, "Empty Fields.", Toast.LENGTH_LONG).show();
                    return;
            }

            Bundle bund = new Bundle();
            bund.putString("username", username);
            Intent i = new Intent(CreateAccountActivity.this, MainActivity.class);
            i.putExtras(bund);
            startActivity(i);
        });


        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(c -> finish());
    }

    /**
     * This function validates the provided username and password text fields before
     * inserting into the database of Users (PokedexDatabase). It will run many
     * checks including making sure fields are not empty, username isn't taken,
     * and storing into database.
     *
     * @param name     holds the new user's full name to store in database
     * @param username string username to validate for the user
     * @param password string password to store for user db
     * @param db       database instance for storing and working with user db
     * @return string validation determining the status of the given username/password
     */
    public static String validate(String name, String username, String password, PokedexDatabase db) {
        // Check if fields are not empty, else
        if (username.equals("") || password.equals(""))
            return "empty fields";
        else {
            // Check if User is in DB using username search
            User isInDb;
            isInDb = db.user().findByUsername(username);

            if (isInDb == null) // Create new User instance and add to DB
                return "valid";
            else // Username was taken
                return "username taken";

        }
    }
}

