package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Patient extends AppCompatActivity {
    Button btnView, btnAdd;
    TextView txt_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        btnView = (Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPatient();
            }
        });

        btnAdd =  findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddPatient();
            }
        });



        txt_head = (TextView) findViewById(R.id.txt_head);
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

    public  void openPatient(){
        Intent intent = new Intent(this, MainActivityPatient.class);
        startActivity(intent);
    }

    public  void openAddPatient(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}