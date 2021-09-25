package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Doctors extends AppCompatActivity {

    Button btnView, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        btnView = (Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDoctor();
            }
        });

        btnAdd =  findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddDoctor();
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

    public  void openDoctor(){
        Intent intent = new Intent(this, viewdoctor.class);
        startActivity(intent);
    }

    public  void openAddDoctor(){
        Intent intent = new Intent(this, MainActivityDoctor.class);
        startActivity(intent);
    }
}