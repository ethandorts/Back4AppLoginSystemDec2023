package com.example.back4apploginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;


public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText passwordText = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.btnSignIn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                userLogin(username, password);
            }
        });
    }

    public void userLogin(String username , String password) {
        ParseUser.logInInBackground(username, password, (parseUser, e) -> {
            if(parseUser != null ) {
                Toast.makeText(SignInActivity.this, "Successful Logged In, Welocme Back " + username + " ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignInActivity.this, LoginSuccessActivity.class);
                intent.putExtra("Name", username);
                startActivity(intent);
            } else {
                ParseUser.logOut();
                Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void GoToSignUp(View view) {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}