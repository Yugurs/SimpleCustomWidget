package com.yugurs.scw.cell;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.yugurs.scw.databinding.MycellActBinding;
import com.yugurs.scw.model.Students;

public class MyCellAct extends AppCompatActivity {

    private MycellActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.mycell_act);
        binding = MycellActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cell.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "点条路你走", Toast.LENGTH_SHORT).show();
        });


        Students students = new Students();

        binding.btnTest.setOnClickListener(v -> {
            students.setName("李QQ");
            binding.setStuVm(students);
        });

    }

}

