package com.example.ourapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupFormActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Perform validation
            if (TextUtils.isEmpty(username)) {
                usernameEditText.setError("Username cannot be empty");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                passwordEditText.setError("Password cannot be empty");
                return;
            }

            // Save the user to the MySQLite database
            MySQLiteHelper dbHelper = new MySQLiteHelper(SignupFormActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("password", password);

            long rowId = db.insert("users", null, values);
            if (rowId != -1) {
                Toast.makeText(SignupFormActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show();
                navigateToLoginActivity(); // Navigate to the login activity
            } else {
                Toast.makeText(SignupFormActivity.this, "Failed to register user.", Toast.LENGTH_SHORT).show();
            }

            db.close();
        });
    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(SignupFormActivity.this, LoginFormActivity.class);
        startActivity(intent);
    }
}
