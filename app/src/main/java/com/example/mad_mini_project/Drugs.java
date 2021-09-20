package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Drugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs);

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
}