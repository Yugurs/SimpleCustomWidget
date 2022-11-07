package com.yugurs.sui.lable;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.yugurs.sui.R;

public class SCWLable extends LinearLayout {

    private View vLeft;
    private TextView tvLable;
    private TextView tvRight;

    public SCWLable(Context context) {
        super(context);
    }

    public SCWLable(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.scwlable_layout, this, true);
        vLeft   = findViewById(R.id.v_left);
        tvLable = findViewById(R.id.tv_lable);
        tvRight = findViewById(R.id.tv_right);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SCWLable);
        if (attributes != null){
            int leftColor = attributes.getColor(R.styleable.SCWLable_vColor, ContextCompat.getColor(context, R.color.test_color));
            leftColor(leftColor);

            String lable = attributes.getString(R.styleable.SCWLable_title);
            Log.e("lable", lable);
            if (lable != "") {
                lable(lable);
            }

            int lableColor = attributes.getColor(R.styleable.SCWLable_titleColor, ContextCompat.getColor(context, R.color.m_text_color));
            lableColor(lableColor);

            float lableSize = attributes.getDimension(R.styleable.SCWLable_titleSize, 16);
            lableSize(lableSize);

            String right = attributes.getString(R.styleable.SCWLable_rightText);
            if (right != ""){
                right(right);
            }

            int rightColor = attributes.getColor(R.styleable.SCWLable_rightColor, ContextCompat.getColor(context, R.color.test_color));
            rightColor(rightColor);

        }

        attributes.recycle();

    }

    public void leftColor(int color){
        vLeft.setBackgroundColor(color);
    }

    public void lable(String str){
        tvLable.setText(str);
    }

    public void lableColor(int color){
        tvLable.setTextColor(color);
    }

    public void lableSize(float size){
        tvLable.setTextSize(size);
    }

    public void right(String str){
        tvRight.setVisibility(VISIBLE);
        tvRight.setText(str);
    }

    public void rightColor(int color){
        tvRight.setTextColor(color);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            tvRight.setOnClickListener(onClickListener);
        }
    }

}

