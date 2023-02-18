package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String gender = intent.getStringExtra("gender");
        String education = intent.getStringExtra("education");
        int age = intent.getIntExtra("age", 0);
        String sports = intent.getStringExtra("sports");
        String music = intent.getStringExtra("music");

        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText(name);

        TextView phoneTextView = findViewById(R.id.phoneTextView);
        phoneTextView.setText(phone);

        TextView genderTextView = findViewById(R.id.genderTextView);
        genderTextView.setText(gender);

        TextView educationTextView = findViewById(R.id.educationTextView);
        educationTextView.setText(education);

        TextView ageTextView = findViewById(R.id.ageTextView);
        ageTextView.setText(String.valueOf(age));

        TextView sportsTextView = findViewById(R.id.sportsTextView);
        sportsTextView.setText(sports);

        TextView musicTextView = findViewById(R.id.musicTextView);
        musicTextView.setText(music);
    }
}