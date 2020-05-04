package com.example.justanotherinventoryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class myAdaptor extends RecyclerView.Adapter<myAdaptor.MyViewHolder> {

    String[] data1;
    String[] data3;
    int[] data2;
    Context context;

    public myAdaptor(Context getContext, String[] s1, String[] s3, int[] s2) {
        context = getContext;
        data1 = s1;
        data3 = s3;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText3.setText(data3[position]);
        holder.myText2.setText(data2[position] + "");

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ModifyItem.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("data2", data2[position] + "");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data2.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText3, myText2;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText3 = itemView.findViewById(R.id.myText3);
            myText2 = itemView.findViewById(R.id.myText2);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

