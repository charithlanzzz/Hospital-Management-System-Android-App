package com.example.mad_mini_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DrugListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DBHelper myDB;
    ArrayList<String> drugId, etNameInsert, etDoseInsert, etDescriptionInsert, etQuantityInsert;
    custom_adapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_list);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrugListActivity.this, AddDrugsActivity.class);
                startActivity(intent);
            }
        });
        myDB = new DBHelper(DrugListActivity.this);

        drugId = new ArrayList<>();
        etNameInsert = new ArrayList<>();
        etDoseInsert = new ArrayList<>();
        etDescriptionInsert = new ArrayList<>();
        etQuantityInsert = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new custom_adapter(DrugListActivity.this, DrugListActivity.this,
                                            drugId, etNameInsert,etDoseInsert, etDescriptionInsert, etQuantityInsert);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DrugListActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                drugId.add(cursor.getString(0));
                etNameInsert.add(cursor.getString(1));
                etDoseInsert.add(cursor.getString(2));
                etDescriptionInsert.add(cursor.getString(3));
                etQuantityInsert.add(cursor.getString(4));
            }
        }
    }
}