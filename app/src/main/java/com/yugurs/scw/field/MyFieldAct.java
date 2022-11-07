package com.yugurs.scw.field;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yugurs.scw.databinding.MyfieldActBinding;

public class MyFieldAct extends AppCompatActivity {

    private MyfieldActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MyfieldActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}

