package com.example.task3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserTable.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao getData();


}
