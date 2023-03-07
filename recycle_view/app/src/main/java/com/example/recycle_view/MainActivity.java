package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<String> myDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.my_recycler_view);
        myDataset.add("Item 1");
        myDataset.add("Item 2");
        myDataset.add("Item 3");
        mRecycleView.setHasFixedSize(true);

        // Thiết lập LayoutManager cho RecyclerView
        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);

        // Khởi tạo adapter cho RecyclerView
        mAdapter = new MyAdapter(myDataset);

        // Gán adapter cho RecyclerView
        mRecycleView.setAdapter(mAdapter);


    }
}