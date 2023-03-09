package com.example.gridview_image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(getBaseContext(), ViewImageActivity.class);
            intent.putExtra("id", gridView.getAdapter().getItemId(i));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemData.init(getApplicationContext());
        ArrayList<Item> items = ItemData.getItems();
        gridView = findViewById(R.id.gridView);
        ItemAdapter adapter = new ItemAdapter(items, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(onItemClick);
    }
}