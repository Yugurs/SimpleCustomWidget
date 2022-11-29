package com.yugurs.scw.field;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yugurs.scw.BR;
import com.yugurs.scw.databinding.MyfieldActBinding;
import com.yugurs.scw.model.Students;

import org.json.JSONObject;

public class MyFieldAct extends AppCompatActivity {

    private MyfieldActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MyfieldActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Students students = new Students();
        binding.setStuVm(students);

        binding.btnTest.setOnClickListener(v -> {
//            students.setName("李QQ");
//            students.setAge("27");
//            binding.setStuVm(students);
            Toast.makeText(getApplicationContext(), "填写了" + students.getName() + '-' + students.getAge(), Toast.LENGTH_SHORT).show();
        });
    }

}

