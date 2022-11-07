package com.yugurs.scw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.yugurs.scw.cell.MyCellAct;
import com.yugurs.scw.databinding.ActivityMainBinding;
import com.yugurs.scw.field.MyFieldAct;
import com.yugurs.scw.lable.MyLableAct;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //private LinearLayout llCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //llCell = findViewById(R.id.ll_cell);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.llCell.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyCellAct.class);
            startActivity(intent);
        });

        binding.llField.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyFieldAct.class);
            startActivity(intent);
        });

        binding.llLable.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyLableAct.class);
            startActivity(intent);
        });


    }


}
