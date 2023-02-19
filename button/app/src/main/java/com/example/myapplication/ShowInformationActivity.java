package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);

        Intent intent = getIntent();
        String buttonName = intent.getStringExtra("buttonName");

        TextView textView = findViewById(R.id.textView);
        textView.setText(buttonName);
    }
}