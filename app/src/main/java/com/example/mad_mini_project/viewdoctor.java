package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class viewdoctor extends AppCompatActivity {

    private Button addmore;
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdoctor);


        SQLiteDatabase db = openOrCreateDatabase("hospitalDB", Context.MODE_PRIVATE, null);

        lst1 = findViewById(R.id.lst1);
        final Cursor c = db.rawQuery("select * from records", null);
        int id = c.getColumnIndex("id");
        int name = c.getColumnIndex("name");
        int specialization = c.getColumnIndex("specialization");
        int ContactNo = c.getColumnIndex("ContactNo");
        titles.clear();

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<doctor> doct = new ArrayList<doctor>();

        if (c.moveToFirst()) {
            do {
                doctor doc = new doctor();
                doc.id = c.getString(id);
                doc.name = c.getString(name);
                doc.specialization = c.getString(specialization);
                doc.ContactNo = c.getString(ContactNo);
                doct.add(doc);

                titles.add(c.getString(id) + " \t " + c.getString(name) + " \t " + c.getString(specialization) + " \t " + c.getString(ContactNo));

            } while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();


        }
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String aa = titles.get(position).toString();
                doctor doc = doct.get(position);
                Intent i = new Intent(getApplicationContext(), editdoctor.class);
                i.putExtra("id", doc.id);
                i.putExtra("name", doc.name);
                i.putExtra("specialization", doc.specialization);
                i.putExtra("ContactNo", doc.ContactNo);
                startActivity(i);


            }
        });




        addmore = (Button) findViewById(R.id.addmore);
        addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityDoctor();
            }

        });
    }

    public void openMainActivityDoctor() {
        Intent intent = new Intent(this, MainActivityDoctor.class);
        startActivity(intent);
    }
}