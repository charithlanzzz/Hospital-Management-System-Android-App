package com.example.mad_mini_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyviewHolder> {

    private Context context;
    Activity activity;
    private ArrayList p_id, p_name, p_contact, p_ward;
    int position;
    Animation translate_anim;

    customAdapter(Activity activity, Context context, ArrayList p_id, ArrayList p_name, ArrayList p_contact, ArrayList p_ward){
        this.activity = activity;
        this.context = context;
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_contact = p_contact;
        this.p_ward = p_ward;

    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return  new MyviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        this.position = position;

        holder.p_id_txt.setText(String.valueOf(p_id.get(position)));
        holder.p_name_txt.setText(String.valueOf(p_name.get(position)));
        holder.p_contact_txt.setText(String.valueOf(p_contact.get(position)));
        holder.p_ward_txt.setText(String.valueOf(p_ward.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("_id", String.valueOf(p_id.get(position)));
                intent.putExtra("name", String.valueOf(p_name.get(position)));
                intent.putExtra("contact", String.valueOf(p_contact.get(position)));
                intent.putExtra("ward", String.valueOf(p_ward.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return p_id.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView p_id_txt, p_name_txt, p_contact_txt, p_ward_txt;
        LinearLayout mainLayout;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            p_id_txt = itemView.findViewById(R.id.p_id_txt);
            p_name_txt = itemView.findViewById(R.id.p_name_txt);
            p_contact_txt = itemView.findViewById(R.id.p_contact_txt);
            p_ward_txt = itemView.findViewById(R.id.p_ward_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            //Animate recyclerview
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
