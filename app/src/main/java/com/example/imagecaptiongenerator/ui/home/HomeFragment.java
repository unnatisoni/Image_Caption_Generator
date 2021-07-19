package com.example.imagecaptiongenerator.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.imagecaptiongenerator.R;
import com.example.imagecaptiongenerator.databinding.FragmentHomeBinding;
import com.example.imagecaptiongenerator.firstpageactivity;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment  {

    private static final int SELECT_PICTURE = 200;
    private static final int PICK_IMAGE = 100;
    Activity context;
    int c =0;


    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ImageView imageview;
    private Button button;
    Uri imageUri;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = getActivity();

        return root;
    }



    public void onStart() {
        super.onStart();
        Button camera = context.findViewById(R.id.camera);
        Button gallery = context.findViewById(R.id.gallery);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, SELECT_PICTURE);


            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });


    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Uri imageUri = data.getData();
            Intent intent = new Intent(getActivity(), firstpageactivity.class);
            intent.putExtra("my_image",imageUri.toString());
            intent.putExtra("flag",1);
            startActivity(intent);

        }
        if (resultCode == RESULT_OK && requestCode == SELECT_PICTURE) {


            Bundle bundle = data.getExtras();
            Bitmap selectedImageUri = (Bitmap) bundle.get("data");
            Intent intent = new Intent(getActivity(), firstpageactivity.class);
            intent.putExtra("my_image_camera", selectedImageUri);
            intent.putExtra("flag",0);
            startActivity(intent);


        }



    }



}


