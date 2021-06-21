package com.example.employeedirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewholder> {
  Context ct;
  List<EmployeeEntity> entityList;

    public EmployeeAdapter(Context ct, List<EmployeeEntity> entityList) {
        this.ct = ct;
        this.entityList = entityList;
    }

    @NonNull
    @Override
    public EmployeeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeViewholder(LayoutInflater.from(ct)
                .inflate(R.layout.each_employee_row,parent,false));



    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewholder holder, int position) {
holder.emp_id.setText(entityList.get(position).getEmpId());
holder.name.setText(entityList.get(position).getEmpName());
holder.address.setText(entityList.get(position).getEmpAddress());
holder.salary.setText(entityList.get(position).getEmpSalary());


    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public class EmployeeViewholder extends RecyclerView.ViewHolder {
        TextView edit,delete,name,address,emp_id,salary;

        public EmployeeViewholder(@NonNull View itemView) {
            super(itemView);
            edit=itemView.findViewById(R.id.tv_edit);
            delete=itemView.findViewById(R.id.tv_delete);
            name=itemView.findViewById(R.id.tv_Name);
            address=itemView.findViewById(R.id.tv_Address);
            salary=itemView.findViewById(R.id.tv_salary);
            emp_id=itemView.findViewById(R.id.tv_id);
        }
    }
}
