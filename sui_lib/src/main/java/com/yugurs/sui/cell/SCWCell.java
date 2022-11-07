package com.yugurs.sui.cell;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.yugurs.sui.R;

public class SCWCell extends LinearLayout {

    private TextView tvLable;
    private TextView tvValue;
    private ImageView ivClick;

    public SCWCell(Context context) {
        super(context);
    }

    public SCWCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.scwcell_layout, this, true);
        tvLable = findViewById(R.id.tv_lable);
        tvValue = findViewById(R.id.tv_value);
        ivClick = findViewById(R.id.iv_click);


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SCWCell);
        if (attributes != null){
            String sLable = attributes.getString(R.styleable.SCWCell_celllable);
            if (sLable != ""){
                cellLable(sLable);
            }

            int lableColor = attributes.getColor(R.styleable.SCWCell_celllableColor, ContextCompat.getColor(context, R.color.m_text_color));
            lableColor(lableColor);

            float fontSize = attributes.getDimension(R.styleable.SCWCell_fontsize, 14);
            fontSize(fontSize);


            int valueColor = attributes.getColor(R.styleable.SCWCell_cellvalueColor, ContextCompat.getColor(context, R.color.m_text_value_color));
            valueColor(valueColor);


            String cellValue = attributes.getString(R.styleable.SCWCell_cellvalue);
            if (cellValue != ""){
                cellValue(cellValue);
            }

            String cellHints = attributes.getString(R.styleable.SCWCell_cellhints);
            if (cellHints != ""){
                cellHints(cellHints);
            }

            int lines = attributes.getInt(R.styleable.SCWCell_celllines, 0);
            if (lines > 0){
                cellLines(lines);
            }

            int path = attributes.getResourceId(R.styleable.SCWCell_cellPic, 0);
            if (path > 0){
                cellPic(path);
            }
        }

        attributes.recycle();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            //tvValue.setOnClickListener(onClickListener);
            ivClick.setOnClickListener(onClickListener);
        }
    }

    public void lableColor(int color){
        tvLable.setTextColor(color);
    }

    public void fontSize(float size){
        tvLable.setTextSize(size);
        tvValue.setTextSize(size);
    }

    public void cellLable(String str){
        tvLable.setText(str);
    }

    public void valueColor(int color){
        tvValue.setTextColor(color);
    }

    public void cellValue(String sValue){
        tvValue.setText(sValue);
    }

    public void cellHints(String sHints){
        tvValue.setHint(sHints);
    }

    public void cellLines(int ilines){
        tvValue.setLines(ilines);
        tvValue.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void cellPic(int path){
        ivClick.setVisibility(VISIBLE);
        ivClick.setImageResource(path);
    }

    public String getValue(){
        return tvValue.getText().toString();
    }

}

