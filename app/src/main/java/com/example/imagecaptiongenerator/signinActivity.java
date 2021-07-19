package com.example.imagecaptiongenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imagecaptiongenerator.ui.DBHelper;
import com.example.imagecaptiongenerator.ui.home.HomeFragment;


public class signinActivity extends AppCompatActivity {
    Button signin;
    ImageButton nextbutton;
    EditText username;
    EditText password;
    DBHelper DB;
    int c=0;


    public static final String filename = "login";
    String SHARED_PREF_NAME="session";
    String SESSION_KEY= "session_user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        signin = findViewById(R.id.signin);
        nextbutton = findViewById(R.id.imageButton);
        DB= new DBHelper(this);

        Intent register = new Intent(this,registeractivity.class);
        Intent firstpage = new Intent(this,OptActivity.class);
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(signinActivity.this,"Enter all the details ",Toast.LENGTH_SHORT).show();

                }
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(signinActivity.this,"Sign in successfully",Toast.LENGTH_SHORT).show();
                        SaveSharedPreference.setUserName(signinActivity.this,user);
                        startActivity(firstpage);
                    }
                    else{
                        Toast.makeText(signinActivity.this,"Invalid Account",Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });



        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(register);
            }
        });
    }
    @Override
    public void onBackPressed() {
        c++;
        if (c == 1) {
            Toast.makeText(signinActivity.this, "Press Again to exit", Toast.LENGTH_SHORT).show();
        }
        if (c == 2) {
            finishAffinity();
        }
    }




}
