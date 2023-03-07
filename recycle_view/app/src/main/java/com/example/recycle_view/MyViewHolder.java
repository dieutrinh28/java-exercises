package com.example.recycle_view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final MyAdapter myAdapter;
    public TextView mTextView;

    public MyViewHolder(View itemView, MyAdapter adapter) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.text_view);
        this.myAdapter = adapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
