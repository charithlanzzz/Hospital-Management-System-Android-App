package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivityDoctor extends AppCompatActivity {

    private Button back_btn;
    EditText ed1, ed2, ed3;
    Button b1, b2;


    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindoctor);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.specialization);
        ed3 = findViewById(R.id.ContactNo);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        awesomeValidation.addValidation(this,R.id.ContactNo,
                "[0-9]{10}",R.string.invalid_ContactNo);


        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), viewdoctor.class);
                startActivity(i);
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    insert();
                    Toast.makeText(getApplicationContext()
                            , "Form Validate Successfully...", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    Toast.makeText(getApplicationContext()
                    ,"Validate Faild.",Toast.LENGTH_SHORT).show();
                    }

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

    public void openhomepage() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);

    }


    public void insert() {
        try {
            String name = ed1.getText().toString();
            String specialization = ed2.getText().toString();
            String ContactNo = ed3.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("hospitalDB", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS records(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,specialization VARCHAR,ContactNo VARCHAR)");

            String sql = "insert into records(name,specialization,ContactNo)values(?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, name);
            statement.bindString(2, specialization);
            statement.bindString(3, ContactNo);
            statement.execute();
            Toast.makeText(this, "Record added Successfully", Toast.LENGTH_LONG).show();

            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();

        } catch (Exception ex) {
            Toast.makeText(this, "Record Fail", Toast.LENGTH_LONG).show();
        }


    }
}