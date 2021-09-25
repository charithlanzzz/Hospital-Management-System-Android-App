package com.example.mad_mini_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityPatient extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn1,tot;

    MydatabaseHelper myDB;
    ArrayList<String> p_id, p_name, p_contact, p_ward;
    customAdapter ca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patienthome);

        recyclerView = findViewById(R.id.recyclerView);
        btn1 = findViewById(R.id.btn1);
        tot = findViewById(R.id.tot_btn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPatient.this, AddActivity.class);
                startActivity(intent);

            }
        });
        //total button
        tot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPatient.this, Total.class);
                startActivity(intent);

            }
        });

        myDB = new MydatabaseHelper(MainActivityPatient.this);
        p_id = new ArrayList<>();
        p_name = new ArrayList<>();
        p_contact = new ArrayList<>();
        p_ward = new ArrayList<>();

        storedataInArrays();

        ca = new customAdapter(MainActivityPatient.this, this, p_id, p_name, p_contact, p_ward);
        recyclerView.setAdapter(ca);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityPatient.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            recreate();
        }
    }

    void storedataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                p_id.add(cursor.getString(0));
                p_name.add(cursor.getString(1));
                p_contact.add(cursor.getString(2));
                p_ward.add(cursor.getString(3));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.deleteAll){
            confirmDialog();

        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All ?");
        builder.setMessage("Are you sure you want to delete all data ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MydatabaseHelper mydb = new MydatabaseHelper(MainActivityPatient.this);
                mydb.deleteAllData();

                //refresh activity
                Intent intent = new Intent(MainActivityPatient.this, MainActivityPatient.class);
                startActivity(intent);
                finish();


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
