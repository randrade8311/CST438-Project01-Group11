package com.example.cst438_project01_group11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private PokedexDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = PokedexDatabase.getInstance(this);

        // creating Buttons
        Button buttonForLoginSystem = findViewById(R.id.login);
        Button buttonForCreateNewAccount = findViewById(R.id.create_account);

        // creating on click listeners
        buttonForLoginSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Input Values
                EditText username1 = findViewById(R.id.username);
                EditText password1 = findViewById(R.id.password);
                String username = username1.getText().toString();
                String password = password1.getText().toString();

                /* Validation */
                List<User> users = new ArrayList<>();
                users = db.user().getAll();

                for(int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUUsername().equals(username) && users.get(i).getUPassword().equals(password)) {
                        Bundle bund = new Bundle();
                        bund.putString("username", username);
                        Intent j = new Intent(LoginActivity.this, MainActivity.class);
                        j.putExtras(bund);
                        startActivity(j);
                        finish();
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Wrong username or password! Try again space cowboy!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            }
        });
        buttonForCreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(i);
            }
        });
    }
}