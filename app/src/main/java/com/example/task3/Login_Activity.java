package com.example.task3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.task3.databinding.ActivityLoginBinding;
import com.example.task3.databinding.ActivityRegistraionBinding;

public class Login_Activity extends AppCompatActivity {
    ActivityLoginBinding binding;
    MyDatabase myDB;
    UserDao userdao;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDB = Room.databaseBuilder(this, MyDatabase.class, "UserTable").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userdao = myDB.getData();

        session = new Session(Login_Activity.this);

        if (session.loggedin())
        {
            startActivity(new Intent(Login_Activity.this, View_Activity.class));

        }


        binding.logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.passUserNameET.getText().toString();
                String password = binding.pPasswordET.getText().toString();

                if (userdao.login(userName, password)) {
                    session.setLoggedin(true);


                    startActivity(new Intent(Login_Activity.this, View_Activity.class));

                } else {
                    Toast.makeText(Login_Activity.this, "Invalid User Name and Password", Toast.LENGTH_SHORT).show();

                }
            }
        });
        binding.regPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, RegistrationActivity.class));

            }
        });


    }




}