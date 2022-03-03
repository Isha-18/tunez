package com.example.tunez;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tunez.databinding.ActivityProfilePageBinding;

public class ProfilePage extends AppCompatActivity {

    ActivityProfilePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfilePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new vector1());
        binding.bottomnav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                
                case R.id.vectorone:
                    replaceFragment(new vector1());
                    break;
                case R.id.vectortwo:
                    replaceFragment(new vector2());
                    break;
                case R.id.vectorthree:
                    replaceFragment(new vector3());
                    break;
                case R.id.vectorfour:
                    replaceFragment(new vector4());
                    break;
                case R.id.vectorfive:
                    replaceFragment(new vector5());
                    break;

            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


}