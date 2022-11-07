package com.yugurs.scw.lable;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yugurs.scw.databinding.MylableActBinding;

public class MyLableAct extends AppCompatActivity {

    private MylableActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MylableActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }


}

