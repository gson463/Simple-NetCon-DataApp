package com.example.ourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class DataCollectionActivityForm2 extends AppCompatActivity {
    private EditText surveyRefEditText;
    private EditText surfaceTypeEditText;
    private EditText carriagewayShapeEditText;
    private EditText carriagewaySurfaceEditText;
    private EditText overallConditionEditText;
    private EditText spotImprovementEditText;
    private EditText leftDrainageEditText;
    private EditText leftSpecialDrainageEditText;
    private EditText leftSlopesEditText;
    private EditText rightDrainageEditText;
    private EditText rightSpecialDrainageEditText;
    private EditText rightSlopesEditText;
    private CheckBox urgentCheckBox;
    private Spinner gravelThicknessSpinner;
    private EditText culvertsRepairEditText;
    private EditText culvertsNewEditText;
    private EditText bridgesRepairEditText;
    private EditText bridgesNewEditText;
    private EditText riverProtectionEditText;
    private EditText notesEditText;
    // Other fields and views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection_form2);

        // Enable the back button in the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Initialize the gravel thickness spinner
        gravelThicknessSpinner = findViewById(R.id.gravelThicknessSpinner);

        // Create an ArrayAdapter for the spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        spinnerAdapter.add("Yes");
        spinnerAdapter.add("No");

        // Set the spinner adapter
        gravelThicknessSpinner.setAdapter(spinnerAdapter);

        // Initialize views
        surveyRefEditText = findViewById(R.id.surveyRefEditText);
        surfaceTypeEditText = findViewById(R.id.surfaceTypeEditText);
        carriagewayShapeEditText = findViewById(R.id.carriagewayShapeEditText);
        carriagewaySurfaceEditText = findViewById(R.id.carriagewaySurfaceEditText);
        overallConditionEditText = findViewById(R.id.overallConditionEditText);
        spotImprovementEditText = findViewById(R.id.spotImprovementEditText);
        leftDrainageEditText = findViewById(R.id.leftDrainageEditText);
        leftSpecialDrainageEditText = findViewById(R.id.leftSpecialDrainageEditText);
        leftSlopesEditText = findViewById(R.id.leftSlopesEditText);
        rightDrainageEditText = findViewById(R.id.rightDrainageEditText);
        rightSpecialDrainageEditText = findViewById(R.id.rightSpecialDrainageEditText);
        rightSlopesEditText = findViewById(R.id.rightSlopesEditText);
        urgentCheckBox = findViewById(R.id.urgentCheckBox);
        gravelThicknessSpinner = findViewById(R.id.gravelThicknessSpinner);
        culvertsRepairEditText = findViewById(R.id.culvertsRepairEditText);
        culvertsNewEditText = findViewById(R.id.culvertsNewEditText);
        bridgesRepairEditText = findViewById(R.id.bridgesRepairEditText);
        bridgesNewEditText = findViewById(R.id.bridgesNewEditText);
        riverProtectionEditText = findViewById(R.id.riverProtectionEditText);
        notesEditText = findViewById(R.id.notesEditText);
        // Initialize other views and fields

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered data
                String surveyRef = surveyRefEditText.getText().toString().trim();
                String surfaceType = surfaceTypeEditText.getText().toString().trim();
                String carriagewayShape = carriagewayShapeEditText.getText().toString().trim();
                String carriagewaySurface = carriagewaySurfaceEditText.getText().toString().trim();
                String overallCondition = overallConditionEditText.getText().toString().trim();
                String spotImprovement = spotImprovementEditText.getText().toString().trim();
                String leftDrainage = leftDrainageEditText.getText().toString().trim();
                String leftSpecialDrainage = leftSpecialDrainageEditText.getText().toString().trim();
                String leftSlopes = leftSlopesEditText.getText().toString().trim();
                String rightDrainage = rightDrainageEditText.getText().toString().trim();
                String rightSpecialDrainage = rightSpecialDrainageEditText.getText().toString().trim();
                String rightSlopes = rightSlopesEditText.getText().toString().trim();
                boolean urgent = urgentCheckBox.isChecked();
                String gravelThickness = gravelThicknessSpinner.getSelectedItem().toString();
                String culvertsRepair = culvertsRepairEditText.getText().toString().trim();
                String culvertsNew = culvertsNewEditText.getText().toString().trim();
                String bridgesRepair = bridgesRepairEditText.getText().toString().trim();
                String bridgesNew = bridgesNewEditText.getText().toString().trim();
                String riverProtection = riverProtectionEditText.getText().toString().trim();
                String notes = notesEditText.getText().toString().trim();
                // Get other entered data

                // Perform validation
                if (TextUtils.isEmpty(surveyRef)) {
                    surveyRefEditText.setError("Survey Ref cannot be empty");
                    return;
                }
                // Add validation for other fields

                // Save the data to the MySQLite database
                MySQLiteHelper dbHelper = new MySQLiteHelper(DataCollectionActivityForm2.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("surveyRef", surveyRef);
                values.put("surfaceType", surfaceType);
                values.put("carriagewayShape", carriagewayShape);
                values.put("carriagewaySurface", carriagewaySurface);
                values.put("overallCondition", overallCondition);
                values.put("spotImprovement", spotImprovement);
                values.put("leftDrainage", leftDrainage);
                values.put("leftSpecialDrainage", leftSpecialDrainage);
                values.put("leftSlopes", leftSlopes);
                values.put("rightDrainage", rightDrainage);
                values.put("rightSpecialDrainage", rightSpecialDrainage);
                values.put("rightSlopes", rightSlopes);
                values.put("urgent", urgent ? 1 : 0);
                values.put("gravelThickness", gravelThickness);
                values.put("culvertsRepair", culvertsRepair);
                values.put("culvertsNew", culvertsNew);
                values.put("bridgesRepair", bridgesRepair);
                values.put("bridgesNew", bridgesNew);
                values.put("riverProtection", riverProtection);
                values.put("notes", notes);
                // Put other data fields

                long rowId = db.insert("form2_data", null, values);
                if (rowId != -1) {
                    Toast.makeText(DataCollectionActivityForm2.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                    // Navigate back to the previous activity or perform other actions
                    onBackPressed();
                } else {
                    Toast.makeText(DataCollectionActivityForm2.this, "Failed to save data.", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Go back when the back button in the action bar is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
