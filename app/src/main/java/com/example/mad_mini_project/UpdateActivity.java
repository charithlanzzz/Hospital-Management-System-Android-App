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

public class UpdateActivity extends AppCompatActivity {

    EditText name_input, contact_input, warrd_input;
    Button up_btn, del_btn;
    String id, name, contact, ward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name_input2);
        contact_input = findViewById(R.id.contact_input2);
        warrd_input = findViewById(R.id.ward_input2);
        up_btn = findViewById(R.id.up_btn);
        del_btn = findViewById(R.id.del_btn);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setTitle(name);
        }

        up_btn.setOnClickListener((view) -> {
            MydatabaseHelper mydb = new MydatabaseHelper(UpdateActivity.this);
            name = name_input.getText().toString().trim();
            contact = contact_input.getText().toString().trim();
            ward = warrd_input.getText().toString().trim();
            mydb.updateData(id, name, contact, ward);

        });
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               confirmDialog();
            }
        });


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("_id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("contact") && getIntent().hasExtra("ward")){

            //getting data from intent

            id = getIntent().getStringExtra("_id");
            name = getIntent().getStringExtra("name");
            contact = getIntent().getStringExtra("contact");
            ward = getIntent().getStringExtra("ward");

            //setting intent data

            name_input.setText(name);
            contact_input.setText(contact);
            warrd_input.setText(ward);


        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MydatabaseHelper mydb = new MydatabaseHelper(UpdateActivity.this);
                mydb.deleteOneRaw(id);

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