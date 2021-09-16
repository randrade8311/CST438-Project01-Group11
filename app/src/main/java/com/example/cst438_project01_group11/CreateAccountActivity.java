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
        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View c) {
                // Input Values
                EditText name1 = findViewById(R.id.name);
                EditText username1 = findViewById(R.id.username);
                EditText password1 = findViewById(R.id.password);
                String name = name1.getText().toString();
                String username = username1.getText().toString();
                String password = password1.getText().toString();

                // Check if fields are not empty, else
                if(username.equals("") || password.equals("")) {
                    Toast.makeText(CreateAccountActivity.this, "Empty Field(s)", Toast.LENGTH_LONG).show();
                }
                else{
                    // Check if User is in DB using username search
                    User isInDb;
                    isInDb = db.user().findByUsername(username);

                    if(isInDb == null){ // Create new User instance and add to DB
                        User user = new User(username, password);
                        db.user().addUser(user);
                        System.out.print("CREATED NEW USER!!!!!!");
                        Toast.makeText(CreateAccountActivity.this, "Account Created", Toast.LENGTH_LONG).show();
                    }
                    else{ // Username was taken
                        Toast.makeText(CreateAccountActivity.this, "Username taken", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View c){finish();}
        });
    }
}

