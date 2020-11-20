package com.example.chap2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    public SearchViewHolder(@Nullable View itemView){
        super(itemView);
    }

    public void bind(String text){
        TextView textview = itemView.findViewById(R.id.text);
        textview.setText(text);
    }
}
