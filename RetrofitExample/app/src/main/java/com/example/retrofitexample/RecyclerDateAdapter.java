package com.example.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerDateAdapter extends
        RecyclerView.Adapter<RecyclerDateAdapter.DateViewHolder> {
    Context ctx;
    List<Repo> list;

    public RecyclerDateAdapter(Context ctx, List<Repo> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DateViewHolder(LayoutInflater.from(ctx).inflate(R.layout.mylayout,
                parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        String finalDate=list.get(position).getDate();
        holder.date.setText(properDateFormat(finalDate));
        holder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String act=String.valueOf(list.get(position).getActive());
            String date=String.valueOf(list.get(position).getDate());
            String rec=String.valueOf(list.get(position).getRecovered());
            String country=String.valueOf(list.get(position).getCountry());
            String cnf=String.valueOf(list.get(position).getConfirmed());
            String deaths=String.valueOf(list.get(position).getDeaths());
            Intent i=new Intent(ctx,DetailsActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("a",act);
            i.putExtra("d",date);
            i.putExtra("r",rec);
            i.putExtra("c",country);
            i.putExtra("cn",cnf);
            i.putExtra("dt",deaths);
            ctx.startActivity(i);



            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DateViewHolder extends RecyclerView.ViewHolder  {
        TextView date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
                    date = itemView.findViewById(R.id.tv_date);

        }


    }

    private String properDateFormat(String resDate) {
        String inputPattern = "yy-mm-dd";
        String outputPattern = "dd-mm-yy";
        SimpleDateFormat inputDate = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputDate = new SimpleDateFormat(outputPattern);
        Date d = null;
        String str = null;
        try {
            d = inputDate.parse(resDate);
            str = outputDate.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
