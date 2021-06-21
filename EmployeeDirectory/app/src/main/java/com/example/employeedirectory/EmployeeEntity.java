package com.example.employeedirectory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "empTable")
public class EmployeeEntity {
    @ColumnInfo(name = "empName")
    String empName;
    @ColumnInfo(name = "empId")
    @PrimaryKey
    String empId;
    @ColumnInfo(name = "empSalary")
    String empSalary;
    @ColumnInfo(name = "empAddress")
    String empAddress;

    /*right click->generate->getters()and Setters->ok->select all*/

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }
}
