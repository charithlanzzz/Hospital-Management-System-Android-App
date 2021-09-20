package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name_input, contact_input, ward_input;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input2);
        contact_input = findViewById(R.id.contact_input2);
        ward_input = findViewById(R.id.ward_input2);

        save_button = findViewById(R.id.up_btn);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MydatabaseHelper myDB = new MydatabaseHelper(AddActivity.this);
                myDB.addPatient(name_input.getText().toString().trim(),
                        contact_input.getText().toString().trim(),
                        Integer.valueOf(ward_input.getText().toString().trim()));
            }
        });
    }
}