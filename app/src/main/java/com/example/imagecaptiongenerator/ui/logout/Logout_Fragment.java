package com.example.imagecaptiongenerator.ui.logout;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.imagecaptiongenerator.R;
import com.example.imagecaptiongenerator.databinding.FragmentGalleryBinding;
import com.example.imagecaptiongenerator.signinActivity;
import com.example.imagecaptiongenerator.ui.gallery.GalleryViewModel;

import java.io.File;


public class Logout_Fragment extends Fragment {
    ImageView image;
    Activity context;
    private LogoutViewModel mViewModel;
    private FragmentGalleryBinding binding;

    public static Logout_Fragment newInstance() {
        return new Logout_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

                             @Nullable Bundle savedInstanceState) {
        context = getActivity();
        //return inflater.inflate(R.layout.logout__fragment , container, false);
        context = getActivity();
        Intent intent = new Intent(getActivity(), signinActivity.class);
        startActivity(intent);

        return null;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        // TODO: Use the ViewModel
    }


}