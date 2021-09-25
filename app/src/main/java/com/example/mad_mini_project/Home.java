package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView txtdashboard = (TextView) findViewById(R.id.txtdashboard);

        txtdashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmenupage();
            }
        });

    }
    public  void openmenupage(){
        Intent intent = new Intent(this, Menu_page.class);
        startActivity(intent);
    }

}