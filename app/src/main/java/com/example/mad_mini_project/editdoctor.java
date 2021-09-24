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

public class editdoctor extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdoctor);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.specialization);
        ed3 = findViewById(R.id.ContactNo);
        ed4 = findViewById(R.id.id);

        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);

        Intent i = getIntent();

        String t1 = i.getStringExtra("id").toString();
        String t2 = i.getStringExtra("name").toString();
        String t3 = i.getStringExtra("specialization").toString();
        String t4 = i.getStringExtra("ContactNo").toString();

        ed4.setText(t1);
        ed1.setText(t2);
        ed2.setText(t3);
        ed3.setText(t4);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete();
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), viewdoctor.class);
                startActivity(i);

            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit();

            }
        });


    }

    public void Delete()
    {
        try
        {
            String id = ed4.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("hospitalDB",Context.MODE_PRIVATE,null);


            String sql = "delete from records where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Record Deleted",Toast.LENGTH_LONG).show();


            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();


        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }
    public void Edit()
    {
        try
        {
            String name = ed1.getText().toString();
            String specialization = ed2.getText().toString();
            String ContactNo = ed3.getText().toString();
            String id = ed4.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("hospitalDB", Context.MODE_PRIVATE,null);

            String sql = "update records set name = ?,specialization=?,ContactNo=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,name);
            statement.bindString(2,specialization);
            statement.bindString(3,ContactNo);
            statement.bindString(4,id);
            statement.execute();
            Toast.makeText(this,"Record added",Toast.LENGTH_LONG).show();

            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }
}