package com.example.cst438_project01_group11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating Buttons
        Button buttonForManageSystem = findViewById(R.id.login);
        Button buttonForCreateNewAccount = findViewById(R.id.create_account);

        // creating on click listeners
        buttonForManageSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Input Values
                EditText username1 = findViewById(R.id.username);
                EditText password1 = findViewById(R.id.password);
                String username = username1.getText().toString();
                String password = password1.getText().toString();

                /* Validation */
                // Iterate over list of Users in DB
                //          Function: return list of users
                // If username + password equals a User
                //          Start LandingPageActivity --> Jasdeep's Home Page
                //          Pass in a bundle with username + name;
                Intent i = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(i);
                // else, display error message
                //      or add functionality to determine whether username or password is wrong
                //      and highlight text field
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