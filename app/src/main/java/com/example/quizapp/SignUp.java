package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button btnSignUp;
    EditText firstNameBox,lastNameBox,emailBox,passwordBox,repeatedPasswordBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = findViewById(R.id.signUpBox);
        emailBox=findViewById(R.id.EmailBox2);
        passwordBox = findViewById(R.id.PasswordBox2);
        firstNameBox = findViewById(R.id.firstNameBox);
        repeatedPasswordBox = findViewById(R.id.repeatedPasswordBox);

        lastNameBox = findViewById(R.id.LastNameBox);
        Intent toLogin = new Intent(SignUp.this,MainActivity.class);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHandler db = new DbHandler(SignUp.this);
                if(passwordBox.getText().toString().equals(repeatedPasswordBox.getText().toString())) {
                    if(db.AddUser(new User(firstNameBox.getText().toString(), lastNameBox.getText().toString(),
                            emailBox.getText().toString(), passwordBox.getText().toString())))
                    {
                        Toast.makeText(SignUp.this, "User was added successfully !", Toast.LENGTH_SHORT).show();

                        startActivity(toLogin);
                    }
                    else
                        Toast.makeText(SignUp.this, "User was not added successfully !", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(SignUp.this, "Password not repeated correctly !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}