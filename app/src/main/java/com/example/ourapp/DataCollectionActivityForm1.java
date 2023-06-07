package com.example.ourapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DataCollectionActivityForm1 extends AppCompatActivity {
    private EditText roadEditText;
    private EditText startEditText;
    private EditText endEditText;
    private EditText linkEditText;
    private Spinner subLinkSpinner;
    private EditText regionEditText;
    private EditText shoulderTypeEditText;
    private Button saveButton;
    private Button nextButton;

    private String[] subLinkItems = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection_form1);

        // Initialize views
        roadEditText = findViewById(R.id.roadEditText);
        startEditText = findViewById(R.id.startEditText);
        endEditText = findViewById(R.id.endEditText);
        linkEditText = findViewById(R.id.linkEditText);
        subLinkSpinner = findViewById(R.id.subLinkSpinner);
        regionEditText = findViewById(R.id.regionEditText);
        shoulderTypeEditText = findViewById(R.id.shoulderTypeEditText);
        saveButton = findViewById(R.id.saveButton);
        nextButton = findViewById(R.id.nextButton);

        // Set spinner items
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subLinkItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subLinkSpinner.setAdapter(spinnerAdapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFormData();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToForm2();
            }
        });
    }

    private void saveFormData() {
        String road = roadEditText.getText().toString().trim();
        String start = startEditText.getText().toString().trim();
        String end = endEditText.getText().toString().trim();
        String link = linkEditText.getText().toString().trim();
        String subLink = subLinkSpinner.getSelectedItem().toString();
        String region = regionEditText.getText().toString().trim();
        String shoulderType = shoulderTypeEditText.getText().toString().trim();

        // Perform validation
        if (TextUtils.isEmpty(road)) {
            roadEditText.setError("Road cannot be empty");
            return;
        }
        //Add validation for other fields here

        // Save the data to the MySQLite database
        MySQLiteHelper dbHelper = new MySQLiteHelper(DataCollectionActivityForm1.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("road", road);
        values.put("start", start);
        values.put("end", end);
        values.put("link", link);
        values.put("subLink", subLink);
        values.put("region", region);
        values.put("shoulderType", shoulderType);
        // Put other data fields

        long rowId = db.insert("form1_data", null, values);
        if (rowId != -1) {
            Toast.makeText(DataCollectionActivityForm1.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
            // Navigate to the next activity or perform other actions
        } else {
            Toast.makeText(DataCollectionActivityForm1.this, "Failed to save data.", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void navigateToForm2() {
        Intent intent = new Intent(DataCollectionActivityForm1.this, DataCollectionActivityForm2.class);
        startActivity(intent);
    }
}
