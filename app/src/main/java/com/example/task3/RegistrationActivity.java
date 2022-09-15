package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.task3.databinding.ActivityRegistraionBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistraionBinding binding;
    MyDatabase myDB;
    UserDao userdao;

    public static boolean isAllowed=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegistraionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDB= Room.databaseBuilder(this,MyDatabase.class,"UserTable").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userdao=myDB.getData();

        binding.regUserNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String userName=s.toString();
                if (userdao.is_token(userName)){
                    isAllowed=false;
                    Toast.makeText(RegistrationActivity.this,"Already Taken",Toast.LENGTH_SHORT).show();
                }
                else {
                    isAllowed=true;
                }

            }

        });
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isAllowed){
                    UserTable userTable=new UserTable(0,binding.regUserNameET.getText().toString(),binding.regPasswordET.getText().toString(),binding.fathersNameET.getText().toString(),binding.mothersNameET.getText().toString(),binding.emailET.getText().toString());
                    userdao.insertUser(userTable);

                    Intent intent=new Intent(RegistrationActivity.this,Login_Activity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(RegistrationActivity.this,"Already Taken",Toast.LENGTH_SHORT).show();

                }
            }
        });
        binding.loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,Login_Activity.class);
                startActivity(intent);

            }
        });


    }
}