package com.example.imagecaptiongenerator.ui.gallery;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.imagecaptiongenerator.R;
import com.example.imagecaptiongenerator.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    Activity context;
    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        context = getActivity();
        return root;
    }

    public void onStart() {
        super.onStart();
        EditText name = context.findViewById(R.id.editTextTextPersonName3);
        EditText feedback = context.findViewById(R.id.feedback);
        Button submit = context.findViewById(R.id.button4);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL,new String("unnati.soni_cs.aiml19@gla.ac.in"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback of app");
                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name.getText()+"\n"+"Feedback : "+feedback.getText());
                intent.setType("message/html");
                try{
                    startActivity(Intent.createChooser(intent,"Please select email"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(getActivity(),"No email clients",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}