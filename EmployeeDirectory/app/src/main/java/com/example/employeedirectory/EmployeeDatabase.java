package com.example.employeedirectory;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = EmployeeEntity.class,version = 1,exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    public abstract EmployeeDAO employeeDAO();
}
