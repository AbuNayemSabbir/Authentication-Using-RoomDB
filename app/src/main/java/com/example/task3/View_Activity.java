package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.task3.databinding.ActivityLoginBinding;
import com.example.task3.databinding.ActivityViewBinding;

import java.util.List;

public class View_Activity extends AppCompatActivity {
    ActivityViewBinding binding;
    MyDatabase myDB;
    UserDao userdao;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        binding= ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDB= Room.databaseBuilder(this,MyDatabase.class,"UserTable").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userdao=myDB.getData();

       // setData();
        session = new Session(View_Activity.this);
        if (!session.loggedin())
        {
            startActivity(new Intent(View_Activity.this, Login_Activity.class));

        }
        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setLoggedin(false);


               startActivity(new Intent(View_Activity.this, Login_Activity.class));





            }
        });

    }

    private void setData() {
        List<UserTable> users=userdao.getAllUsers();
        String str="";
        for (UserTable user : users)
            str= str +"\t  "+ user.getId()+ "   "+ user.getUserName()+"   "+ user.getPassword()+" "+ user.getFathersName()+ "   "+ user.getMothersName()+"   "+ user.getEmail()+"\n\n";

        binding.dataHolder.setText(str);
    }
}