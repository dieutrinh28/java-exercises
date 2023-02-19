package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        textView = findViewById(R.id.txt_history);
        Intent intent = getIntent();
        String result = intent.getStringExtra("HISTORY");

//        String history = intent.getStringExtra("HISTORY");
//        textView.setText(history);
        result = result.replace("null","");
        String[] fnresult = result.split("/");
        StringBuilder sb = new StringBuilder();
        for (String s : fnresult) {
            sb.append(s).append("\n");
        }
        textView.setText(sb.toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("history", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("history"));
    }


}