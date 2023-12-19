package com.example.back4apploginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        TextView txtname = (TextView) findViewById(R.id.txtViewMessage);
        Intent intent = getIntent();
        String loginName = intent.getStringExtra("Name");
        txtname.setText("Welcome, " + loginName);
    }

    public void logOutOK(View view) {
        Intent intent = new Intent(LoginSuccessActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}