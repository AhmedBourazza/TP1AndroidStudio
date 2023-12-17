package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnSignUp;
    EditText emailBox,passwordBox;
    DbHandler db;
    // ... (your previous code remains the same)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignup);

        emailBox = findViewById(R.id.EmailBox);
        passwordBox = findViewById(R.id.passwordBox);
        Intent toSignUp = new Intent(this, SignUp.class);
        db = new DbHandler(MainActivity.this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toSignUp);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin(); // Call the checkLogin method to validate login credentials
            }
        });
    }

    public void checkLogin() {
        if (db.checkLogin(emailBox.getText().toString(), passwordBox.getText().toString())) {
            Toast.makeText(MainActivity.this, "Congratulations", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, CalculActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}