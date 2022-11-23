package com.yugurs.scw.label;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yugurs.scw.databinding.MylabelActBinding;

public class MyLabelAct extends AppCompatActivity {

    private MylabelActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MylabelActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.scwLabel.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "点击到了", Toast.LENGTH_SHORT).show();
        });
    }


}

