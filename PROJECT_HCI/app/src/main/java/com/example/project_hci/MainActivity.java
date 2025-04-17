package com.example.project_hci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton;
    TextView signUpText;

    // Dummy credentials (for testing only)
    String dummyUsername = "testuser";
    String dummyPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signUpText);

        // Handle Login
        loginButton.setOnClickListener(v -> {
            String inputUser = username.getText().toString();
            String inputPass = password.getText().toString();

            if (inputUser.equals(dummyUsername) && inputPass.equals(dummyPassword)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // Go to Sign Up Page
        signUpText.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivitySignUp.class);
            startActivity(intent);
        });
    }
}
