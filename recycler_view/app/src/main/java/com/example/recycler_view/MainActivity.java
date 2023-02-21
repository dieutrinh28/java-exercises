package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<MyItem> itemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyItem myItem1 = new MyItem(R.drawable.champagne_toast, "Champagne Toast", "sweet notes of peach, nectarine, and vanilla");
        MyItem myItem2 = new MyItem(R.drawable.a_thousand_wishes, "A Thousand Wishes", "sweet notes of peach, nectarine, and vanilla");
        MyItem myItem3 = new MyItem(R.drawable.gingham, "Gingham", "sweet notes of peach, nectarine, and vanilla");
        MyItem myItem4 = new MyItem(R.drawable.ginghamlove, "Gingham Love", "sweet notes of peach, nectarine, and vanilla");
        MyItem myItem5 = new MyItem(R.drawable.in_the_stars, "In the stars", "sweet notes of peach, nectarine, and vanilla");
        MyItem myItem6 = new MyItem(R.drawable.into_the_night, "Champagne Toast", "sweet notes of peach, nectarine, and vanilla");

        itemList.add(myItem1);
        itemList.add(myItem2);
        itemList.add(myItem3);
        itemList.add(myItem4);
        itemList.add(myItem5);
        itemList.add(myItem6);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}