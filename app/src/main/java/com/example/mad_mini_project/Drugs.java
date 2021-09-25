package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Drugs extends AppCompatActivity {

    Button btnView, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs);

        btnView = (Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrugs();
            }
        });

        btnAdd =  findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddDrugs();
            }
        });

        TextView txt_head = (TextView) findViewById(R.id.txt_head);
        txt_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhomepage();
            }
        });
    }

    public  void openhomepage(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public  void openDrugs(){
        Intent intent = new Intent(this, DrugListActivity.class);
        startActivity(intent);
    }

    public  void openAddDrugs(){
        Intent intent = new Intent(this, AddDrugsActivity.class);
        startActivity(intent);
    }
}