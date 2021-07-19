package com.example.imagecaptiongenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.imagecaptiongenerator.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
     private static int SPLASH_TIME_OUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent firstpage = new Intent(MainActivity.this, signinActivity.class);
                startActivity(firstpage);
            }
        },SPLASH_TIME_OUT);

     


    }
}