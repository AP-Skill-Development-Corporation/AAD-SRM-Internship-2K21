package com.example.employeedirectory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDAO {
    @Insert
    public void insert(EmployeeEntity employeeEntity);
    @Update
    public void update(EmployeeEntity employeeEntity);
    @Delete
    public void delete(EmployeeEntity employeeEntity);
    @Query("select * from empTable")
    public List<EmployeeEntity> retrive();

}
