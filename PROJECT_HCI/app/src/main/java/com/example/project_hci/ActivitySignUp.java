package com.example.project_hci;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_hci.R;

public class ActivitySignUp extends AppCompatActivity {

    EditText username, email, password, confirmPassword;
    Button signUpButton;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.usernameSignUp);
        email = findViewById(R.id.emailSignUp);
        password = findViewById(R.id.passwordSignUp);
        confirmPassword = findViewById(R.id.confirmPasswordSignUp);
        signUpButton = findViewById(R.id.signUpButton);
        loginText = findViewById(R.id.loginText);

        // Go back to Login
        loginText.setOnClickListener(v -> {
            startActivity(new Intent(ActivitySignUp.this, MainActivity.class));
            finish();
        });

        // Handle Sign Up
        signUpButton.setOnClickListener(v -> {
            String user = username.getText().toString();
            String emailInput = email.getText().toString();
            String pass = password.getText().toString();
            String confirm = confirmPassword.getText().toString();

            if (user.isEmpty() || emailInput.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else if (!pass.equals(confirm)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ActivitySignUp.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
