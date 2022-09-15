package com.example.task3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class UserTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String password;
    private String fathersName;
    private String mothersName;
    private String email;

    public UserTable(int id, String userName, String password, String fathersName, String mothersName, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
