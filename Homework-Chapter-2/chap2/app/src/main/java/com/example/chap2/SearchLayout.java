package com.example.chap2;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;


public class SearchLayout extends FrameLayout {

    private OnInputChangedListener OnInputChangedListener;

    public SearchLayout(Context context){
        super(context);
        init();
    }
    public SearchLayout(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }
    public SearchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.layout_search, this);

        EditText input = findViewById(R.id.input);
        TextView mCancel = findViewById(R.id.cancel);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("SearchLayout","onTextChanged: "+s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (OnInputChangedListener != null) {
                    OnInputChangedListener.onTextChanged(s.toString());
                }
            }
        });

        mCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    public void setOnInputChangedListener(OnInputChangedListener Listener){
        this.OnInputChangedListener = Listener;
    }
    public interface OnInputChangedListener{
        void onTextChanged(String text);
    }
}
