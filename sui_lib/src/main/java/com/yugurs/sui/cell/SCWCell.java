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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.yugurs.sui.R;

public class SCWCell extends LinearLayout {

    private TextView tvLabel;
    private TextView tvValue;
    private ImageView ivClick;

    public SCWCell(Context context) {
        super(context);
    }

    public SCWCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.scwcell_layout, this, true);
        tvLabel = findViewById(R.id.tv_label);
        tvValue = findViewById(R.id.tv_value);
        ivClick = findViewById(R.id.iv_click);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SCWCell);
        if (attributes != null){
            String sLabel = attributes.getString(R.styleable.SCWCell_cellLabel);
            if (sLabel != ""){
                cellLabel(sLabel);
            }

            int labelColor = attributes.getColor(R.styleable.SCWCell_cellLabelColor, ContextCompat.getColor(context, R.color.m_text_color));
            labelColor(labelColor);

            float fontSize = attributes.getDimension(R.styleable.SCWCell_fontSize, 14);
            fontSize(fontSize);

            int valueColor = attributes.getColor(R.styleable.SCWCell_cellValueColor, ContextCompat.getColor(context, R.color.m_text_value_color));
            valueColor(valueColor);


            String cellValue = attributes.getString(R.styleable.SCWCell_cellValue);
            if (cellValue != ""){
                cellValue(cellValue);
            }

            String cellHints = attributes.getString(R.styleable.SCWCell_cellHints);
            if (cellHints != ""){
                cellHints(cellHints);
            }

            int lines = attributes.getInt(R.styleable.SCWCell_cellLines, 0);
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

    public void labelColor(int color){
        tvLabel.setTextColor(color);
    }

    public void fontSize(float size){
        tvLabel.setTextSize(size);
        tvValue.setTextSize(size);
    }

    public void cellLabel(String str){
        tvLabel.setText(str);
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

    @BindingAdapter("app:cellValue")
    public static void setBindValue(AppCompatEditText appEdt, String value){
        appEdt.setText(value);
        //fieldValueChanged.onChange();
    }

    //, event = "app:fieldValueChanged"
    @InverseBindingAdapter(attribute = "app:cellValue")
    public static String getBindValue(AppCompatEditText appEdt){
        return appEdt.getText().toString().trim();
    }
}

