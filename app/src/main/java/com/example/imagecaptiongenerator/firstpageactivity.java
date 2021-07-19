package com.example.imagecaptiongenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.imagecaptiongenerator.databinding.ActivityFirstpageactivityBinding;
import com.example.imagecaptiongenerator.databinding.ActivityOptBinding;
import com.example.imagecaptiongenerator.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.example.imagecaptiongenerator.ui.gallery.GalleryFragment;
import com.example.imagecaptiongenerator.ui.home.HomeFragment;
import com.example.imagecaptiongenerator.ui.home.HomeViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imagecaptiongenerator.databinding.ActivityOptBinding;
//AppCompatActivity

public class firstpageactivity extends AppCompatActivity {
    ImageView imageview;
    int checker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpageactivity);
        imageview = findViewById(R.id.selected_image);

        Intent intent = getIntent();
        checker= (int)intent.getIntExtra("flag",0);
        if(checker==0){
            Bitmap bitmap = (Bitmap)intent.getParcelableExtra("my_image_camera");
            imageview.setImageBitmap(bitmap);
        }

        if(checker==1){
            Uri myuri = Uri.parse(intent.getStringExtra("my_image"));
            imageview.setImageURI(myuri);

        }





    }




}

