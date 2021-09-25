package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDrugsActivity extends AppCompatActivity {
    EditText etNameInsert;
    EditText etDoseInsert;
    EditText etDescriptionInsert;
    EditText etQuantityInsert;
    Button btnAddInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drugs);

        etNameInsert = findViewById(R.id.etNameInsert);
        etDoseInsert = findViewById(R.id.etDoseInsert);
        etDescriptionInsert = findViewById(R.id.etDescriptionInsert);
        etQuantityInsert = findViewById(R.id.etQuantityInsert);
        btnAddInsert = findViewById(R.id.btnAddInsert);

        btnAddInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                MydatabaseHelper myDB = new MydatabaseHelper(AddDrugsActivity.this);
=======
                DBHelper myDB = new DBHelper(AddDrugsActivity.this);
>>>>>>> drug_management
                myDB.addDrugs(etNameInsert.getText().toString().trim(),
                        etDoseInsert.getText().toString().trim(),
                        etDescriptionInsert.getText().toString().trim(),
                        Integer.valueOf(etQuantityInsert.getText().toString().trim()));
            }
        });
    }
}