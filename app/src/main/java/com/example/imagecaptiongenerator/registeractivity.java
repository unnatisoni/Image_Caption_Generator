package com.example.imagecaptiongenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imagecaptiongenerator.ui.DBHelper;

public class registeractivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText ConfirmPassword;
    DBHelper DB;
    int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        DB = new DBHelper(this);
        Intent firstpage = new Intent(this,OptActivity.class);
        Intent signin = new Intent(this,signinActivity.class);
        Button next = findViewById(R.id.button3);
        ImageButton sign = findViewById(R.id.imageButton4);
        username = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.editTextTextPassword2);
        ConfirmPassword = findViewById(R.id.editTextTextPassword3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = ConfirmPassword.getText().toString();
                if(user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(registeractivity.this,"Please enter all the details",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert == true){
                                Toast.makeText(registeractivity.this,"register successfull",Toast.LENGTH_SHORT).show();
                                startActivity(firstpage);
                            }
                            else{
                                Toast.makeText(registeractivity.this,"registration failed!!",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            Toast.makeText(registeractivity.this,"USer already exist",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(registeractivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signin);
            }
        });
    }

    @Override
    public void onBackPressed() {
        c++;
        if (c == 1) {
            Toast.makeText(registeractivity.this, "Press Again to exit", Toast.LENGTH_SHORT).show();
        }
        if (c == 2) {
            finishAffinity();
        }
    }
}