package com.yugurs.sui.field;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

import com.yugurs.sui.R;

@InverseBindingMethods({@InverseBindingMethod(type = SCWTextArea.class, attribute = "setTaValue", event = "taValueAttrChanged", method = "getTaValue")})
public class SCWTextArea extends LinearLayout {

    private TextView mTextView;
    private AppCompatEditText mEditText;

    public SCWTextArea(Context context) {
        super(context);
    }

    public SCWTextArea(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.scwtextarea_layout, this, true);
        mTextView = findViewById(R.id.tv_label);
        mEditText = findViewById(R.id.edt_value);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SCWTextArea);
        if (attributes != null){
            boolean enable = attributes.getBoolean(R.styleable.SCWTextArea_taEnable, true);
            enable(enable);

            int labelColor = attributes.getColor(R.styleable.SCWTextArea_taLabelColor, ContextCompat.getColor(context, R.color.m_text_color));
            labelColor(labelColor);

            String lable = attributes.getString(R.styleable.SCWTextArea_taLabel);
            if (lable != ""){
                lable(lable);
            }

            int valueColor = attributes.getColor(R.styleable.SCWTextArea_taValueColor, ContextCompat.getColor(context, R.color.m_text_color));
            valueColor(valueColor);

            String value = attributes.getString(R.styleable.SCWTextArea_taValue);
            if (value != ""){
                value(value);
            }

            float fontSize = attributes.getDimension(R.styleable.SCWTextArea_taSize, 14);
            fontSize(fontSize);

            int hintColor = attributes.getColor(R.styleable.SCWTextArea_taHintColor, ContextCompat.getColor(context, R.color.m_text_value_color));
            hintColor(hintColor);

            String hints = attributes.getString(R.styleable.SCWTextArea_taHints);
            if (hints != ""){
                hints(hints);
            }

            attributes.recycle();

        }

    }

    public void enable(boolean able){
        mEditText.setEnabled(able);
    }

    public void labelColor(int color){
        mTextView.setTextColor(color);
    }

    public void valueColor(int color){
        mEditText.setTextColor(color);
    }

    public void hintColor(int color){
        mEditText.setHintTextColor(color);
    }

    public void fontSize(float size){
        mTextView.setTextSize(size);
        mEditText.setTextSize(size);
    }

    public void hints(CharSequence hints){
        mEditText.setHint(hints);
    }

    public void lable(String slable){
        mTextView.setText(slable);
    }

    public void value(String value){
        mEditText.setText(value);
    }

    public String getValue(){
        return mEditText.getText().toString().trim();
    }

    @BindingAdapter("taValue")
    public static void setTaValue(SCWTextArea scwTextArea, String str){
        scwTextArea.mEditText.setText(str);
    }

    @InverseBindingAdapter(attribute = "taValue")
    public static String getTaValue(SCWTextArea scwTextArea){
        return scwTextArea.mEditText.getText().toString().trim();
    }

    @BindingAdapter(value = {"taValueAttrChanged"}, requireAll = false)
    public static void setListeners(SCWTextArea scwTextArea, final InverseBindingListener attrChange){
        if (attrChange == null){

        } else {
            scwTextArea.mEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    attrChange.onChange();
                }
            });

        }
    }

}

