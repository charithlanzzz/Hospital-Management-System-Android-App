package com.example.mad_mini_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDrugsActivity extends AppCompatActivity {

    EditText etNameInsert;
    EditText etDoseInsert;
    EditText etDescriptionInsert;
    EditText etQuantityInsert;
    Button btnUpdate_update, btnDelete_update;

    String id, title, name, dose, description, quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_drugs);

        etNameInsert = findViewById(R.id.etNameUpdate);
        etDoseInsert = findViewById(R.id.etDoseUpdate);
        etDescriptionInsert = findViewById(R.id.etDescriptionUpdate);
        etQuantityInsert = findViewById(R.id.etQuantityUpdate);
        btnUpdate_update = findViewById(R.id.btnUpdate_update);
        btnDelete_update = findViewById(R.id.btnDelete_update);

        getAndSetIntentData();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

        btnUpdate_update.setOnClickListener((view)  -> {

<<<<<<< HEAD
            MydatabaseHelper myDB = new MydatabaseHelper(UpdateDrugsActivity.this);
            name = etNameInsert.getText().toString().trim();
            dose = etDoseInsert.getText().toString().trim();
            description = etDescriptionInsert.getText().toString().trim();
            quantity = etQuantityInsert.getText().toString().trim();
            myDB.updateDataD(id, name, dose, description, quantity);
=======
                DBHelper myDB = new DBHelper(UpdateDrugsActivity.this);
                name = etNameInsert.getText().toString().trim();
                dose = etDoseInsert.getText().toString().trim();
                description = etDescriptionInsert.getText().toString().trim();
                quantity = etQuantityInsert.getText().toString().trim();
                myDB.updateData(id, name, dose, description, quantity);
>>>>>>> drug_management

        });

        btnDelete_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
<<<<<<< HEAD
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("dose") &&
                getIntent().hasExtra("description") && getIntent().hasExtra("quantity")){
=======
       if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("dose") &&
               getIntent().hasExtra("description") && getIntent().hasExtra("quantity")){
>>>>>>> drug_management
            //Getting data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            dose = getIntent().getStringExtra("dose");
            description = getIntent().getStringExtra("description");
<<<<<<< HEAD
            quantity = getIntent().getStringExtra("quantity");
=======
           quantity = getIntent().getStringExtra("quantity");
>>>>>>> drug_management

            //Setting Intent Data
            etNameInsert.setText(name);
            etDoseInsert.setText(dose);
            etDescriptionInsert.setText(description);
            etQuantityInsert.setText(quantity);

        }else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        name = getIntent().getStringExtra("name");
        etNameInsert.setText(name);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
<<<<<<< HEAD
                MydatabaseHelper myDB = new MydatabaseHelper(UpdateDrugsActivity.this);
                myDB.deleteOneRawD(id);
=======
                DBHelper myDB = new DBHelper(UpdateDrugsActivity.this);
                myDB.deleteOneRow(id);
>>>>>>> drug_management
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}