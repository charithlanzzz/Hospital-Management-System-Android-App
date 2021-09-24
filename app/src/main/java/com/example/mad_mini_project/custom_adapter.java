package com.example.mad_mini_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList drugId, etNameInsert, etDoseInsert, etDescriptionInsert, etQuantityInsert;

    int position;

    custom_adapter(Activity activity, Context context, ArrayList drugId, ArrayList etNameInsert, ArrayList etDoseInsert, ArrayList etDescriptionInsert, ArrayList etQuantityInsert){
        this.activity = activity;
        this.context = context;
        this.drugId = drugId;
        this.etNameInsert = etNameInsert;
        this.etDoseInsert = etDoseInsert;
        this.etDescriptionInsert = etDescriptionInsert;
        this.etQuantityInsert = etQuantityInsert;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.position = position;

        holder.drug_id_text.setText(String.valueOf(drugId.get(position)));
        holder.drug_name_text.setText(String.valueOf(etNameInsert.get(position)));
        holder.drug_dose_text.setText(String.valueOf(etDoseInsert.get(position)));
        holder.drug_description_text.setText(String.valueOf(etDescriptionInsert.get(position)));
        holder.drug_quantity_text.setText(String.valueOf(etQuantityInsert.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateDrugsActivity.class);

                intent.putExtra("id", String.valueOf(drugId.get(position)));
                intent.putExtra("name", String.valueOf(etNameInsert.get(position)));
                intent.putExtra("dose", String.valueOf(etDoseInsert.get(position)));
                intent.putExtra("description", String.valueOf(etDescriptionInsert.get(position)));
                intent.putExtra("quantity", String.valueOf(etQuantityInsert.get(position)));
                activity.startActivityForResult(intent, 1);


            }
        });

    }

    @Override
    public int getItemCount() {
        return drugId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView drug_id_text, drug_name_text, drug_dose_text, drug_description_text, drug_quantity_text;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            drug_id_text = itemView.findViewById(R.id.drug_id_text);
            drug_name_text = itemView.findViewById(R.id.drug_name_text);
            drug_dose_text = itemView.findViewById(R.id.drug_dose_text);
            drug_description_text = itemView.findViewById(R.id.drug_description_text);
            drug_quantity_text = itemView.findViewById(R.id.drug_quantity_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
