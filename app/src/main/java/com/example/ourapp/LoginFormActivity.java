package com.example.ourapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginFormActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        TextView signupTextView = findViewById(R.id.signupTextView);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> {
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

            // Check if the user exists in the MySQLite database
            MySQLiteHelper dbHelper = new MySQLiteHelper(LoginFormActivity.this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String selection = "username = ? AND password = ?";
            String[] selectionArgs = {username, password};
            Cursor cursor = db.query("users", null, selection, selectionArgs, null, null, null);
            if (cursor.getCount() > 0) {
                // User exists, navigate to DataCollectionActivityForm1
                Intent intent = new Intent(LoginFormActivity.this, DataCollectionActivityForm1.class);
                startActivity(intent);
                finish(); // Optional: Finish the current activity to prevent going back to it
            } else {
                // User does not exist or incorrect credentials
                Toast.makeText(LoginFormActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
            }

            cursor.close();
            db.close();
        });

        // Handle signup link click
        signupTextView.setOnClickListener(v -> {
            // Start the SignupFormActivity
            Intent intent = new Intent(LoginFormActivity.this, SignupFormActivity.class);
            startActivity(intent);
        });
    }
}
