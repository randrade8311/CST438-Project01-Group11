package com.example.cst438_project01_group11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent i = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(i);
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