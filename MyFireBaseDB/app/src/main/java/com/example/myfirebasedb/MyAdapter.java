package com.example.myfirebasedb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    DisplayActivity ctx;
    List<StudentModel> list;

    public MyAdapter(DisplayActivity ctx, List<StudentModel> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t_name.setText(list.get(position).getName());
        holder.t_email.setText(list.get(position).getEmail());
        holder.t_mobile.setText(list.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t_name, t_email, t_mobile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t_email = itemView.findViewById(R.id.tv_email);
            t_name = itemView.findViewById(R.id.tv_name);
            t_mobile = itemView.findViewById(R.id.tv_mobile);
        }
    }
}
