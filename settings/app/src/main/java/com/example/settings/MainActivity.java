package com.example.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    int backgroundColor = Color.WHITE;
    int textColor = Color.BLACK;
    int counter = 0;


    LinearLayout layout;
    Button buttonBlack;
    Button buttonRed;
    Button buttonBlue;
    Button buttonGreen;
    Button clearButton;

    Button buttonCounter;


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Preferences prefs = Preferences.userNodeForPackage(getClass());
        prefs.putInt("counter", counter);

        layout = findViewById(R.id.layout);
        layout.setBackgroundColor(backgroundColor);

        buttonRed = findViewById(R.id.btnRed);
        buttonRed.setBackgroundColor(Color.RED);

        buttonBlue = findViewById(R.id.btnBlue);
        buttonBlue.setBackgroundColor(Color.BLUE);

        buttonBlack = findViewById(R.id.btnBlack);
        buttonBlack.setBackgroundColor(Color.BLACK);

        buttonGreen = findViewById(R.id.btnGreen);
        buttonGreen.setBackgroundColor(Color.GREEN);

        clearButton = findViewById(R.id.btnClear);
        clearButton.setBackgroundColor(Color.GRAY);

        buttonCounter = findViewById(R.id.btnCounter);
        buttonCounter.setBackgroundColor(Color.TRANSPARENT);
        buttonCounter.setTextColor(Color.BLACK);

        textView = findViewById(R.id.textview);
        textView.setText(String.valueOf(counter));
        textView.setTextColor(textColor);

        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = prefs.getInt("counter", 0);
                counter++;
                prefs.putInt("counter", counter);
                textView.setText(String.valueOf(counter));
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.BLUE;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                prefs.put("backgroundColor", String.valueOf(backgroundColor));
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.GREEN;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                prefs.put("backgroundColor", String.valueOf(backgroundColor));
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.RED;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                prefs.put("backgroundColor", String.valueOf(backgroundColor));
            }
        });

        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.BLACK;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                prefs.put("backgroundColor", String.valueOf(backgroundColor));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.WHITE;
                textColor = Color.BLACK;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                prefs.remove("backgroundColor");
                counter = 0;
                prefs.putInt("counter", counter);
                textView.setText(String.valueOf(counter));
            }
        });

    }

}