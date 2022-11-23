package com.yugurs.sui.field;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

import com.yugurs.sui.R;

public class SCWField extends LinearLayout {

    private TextView mTextView;
    private AppCompatEditText mEditText;

    public SCWField(Context context) {
        super(context);
    }

    public SCWField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.swcfield_layout, this, true);
        mTextView = findViewById(R.id.tv_label);
        mEditText = findViewById(R.id.edt_value);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SCWField);
        if (attributes != null){
            boolean enable = attributes.getBoolean(R.styleable.SCWField_fieldEnable, true);
            enable(enable);

            int lableColor = attributes.getColor(R.styleable.SCWField_fieldLabelColor, ContextCompat.getColor(context, R.color.m_text_color));
            lableColor(lableColor);

            String lable = attributes.getString(R.styleable.SCWField_fieldLabel);
            if (lable != ""){
                lable(lable);
            }

            int valueColor = attributes.getColor(R.styleable.SCWField_fieldLabelColor, ContextCompat.getColor(context, R.color.m_text_color));
            valueColor(valueColor);

            String value = attributes.getString(R.styleable.SCWField_fieldValue);
            if (value != ""){
                value(value);
            }

            int gravity = attributes.getInteger(R.styleable.SCWField_valueGravity, Gravity.RIGHT|Gravity.CENTER_VERTICAL);
            gravity(gravity);

            float fieldSize = attributes.getDimension(R.styleable.SCWField_fieldSize, 14);
            size(fieldSize);

            int hintColor = attributes.getColor(R.styleable.SCWField_fieldHintColor, ContextCompat.getColor(context, R.color.m_text_value_color));
            hintColor(hintColor);

            String hints = attributes.getString(R.styleable.SCWField_fieldHints);
            if (hints != ""){
                hints(hints);
            }

            int inputType = attributes.getInteger(R.styleable.SCWField_inputType, InputType.TYPE_NULL);
            if (inputType > 0){
                inputType(inputType);
            }

            int lines = attributes.getInt(R.styleable.SCWField_fieldLines, 0);
            if (lines > 0){
                fieldLines(lines);
            }

            attributes.recycle();
        }

    }

    public void enable(boolean able){
        mEditText.setEnabled(able);
    }

    public void lableColor(int color){
        mTextView.setTextColor(color);
    }

    public void valueColor(int color){
        mEditText.setTextColor(color);
    }

    public void hintColor(int color){
        mEditText.setHintTextColor(color);
    }

    public void size(float size){
        mTextView.setTextSize(size);
        mEditText.setTextSize(size);
    }

    public void hints(CharSequence hints){
        mEditText.setHint(hints);
    }

    public void inputType(int type){
        mEditText.setInputType(type);
    }

    public void fieldLines(int ilines){
        mEditText.setLines(ilines);
        mEditText.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void lable(String slable){
        mTextView.setText(slable);
    }

    public void value(String value){
         mEditText.setText(value);
    }

    public void gravity(int gravity){
        mEditText.setGravity(gravity);
    }

    public String getValue(){
        return mEditText.getText().toString().trim();
    }

}

