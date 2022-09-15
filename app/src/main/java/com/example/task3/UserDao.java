package com.example.task3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserTable userTable);

    @Query("SELECT EXISTS(SELECT * FROM UserTable WHERE userName=:userName)")
    boolean is_token(String userName);

    @Query("SELECT EXISTS(SELECT * FROM UserTable WHERE userName=:userName AND password=:password)")
    boolean login(String userName, String password);

    @Query("SELECT * FROM UserTable")
    List<UserTable> getAllUsers();

}
