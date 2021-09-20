package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        TextView doc_btn = (TextView) findViewById(R.id.doc_btn);
        doc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDoctors();
            }
        });

        TextView pat_btn = (TextView) findViewById(R.id.pat_btn);
        pat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPatient();
            }
        });


        TextView drugs_btn = (TextView) findViewById(R.id.drugs_btn);
        drugs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrugs();
            }
        });

        Button back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, Drugs.class);
        startActivity(intent);
    }
    public  void openPatient(){
        Intent intent = new Intent(this, Patient.class);
        startActivity(intent);
    }
    public  void openDoctors(){
        Intent intent = new Intent(this, Doctors.class);
        startActivity(intent);
    }
}
