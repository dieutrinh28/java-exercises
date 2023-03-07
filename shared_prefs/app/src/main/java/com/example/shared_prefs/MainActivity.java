package com.example.shared_prefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int backgroundColor = Color.WHITE;
    private int textColor = Color.BLACK;

    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "my_shared_pref";
    private static final String COUNTER_KEY = "counter";

    private String BACKGROUND_COLOR_KEY = "background_color";
    private String TEXT_COLOR_KEY = "text_color";


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

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        // Lấy giá trị của biến đếm, mặc định là 0 nếu không có giá trị
        int counter = sharedPreferences.getInt(COUNTER_KEY, 0);

        if (sharedPreferences.contains(BACKGROUND_COLOR_KEY)) {
            backgroundColor = sharedPreferences.getInt(BACKGROUND_COLOR_KEY, Color.WHITE);
        }

        if (sharedPreferences.contains(TEXT_COLOR_KEY)) {
            textColor = sharedPreferences.getInt(TEXT_COLOR_KEY, Color.BLACK);
        }

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


        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.GREEN;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
                editor.putInt(TEXT_COLOR_KEY, textColor);
                editor.apply();
            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.RED;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
                editor.putInt(TEXT_COLOR_KEY, textColor);
                editor.apply();
            }
        });
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.BLACK;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                textView.setTextColor(Color.WHITE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
                editor.putInt(TEXT_COLOR_KEY, textColor);
                editor.apply();
            }
        });
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.BLUE;
                textColor = Color.WHITE;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
                editor.putInt(TEXT_COLOR_KEY, textColor);
                editor.apply();
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor = Color.WHITE;
                textColor = Color.BLACK;
                layout.setBackgroundColor(backgroundColor);
                textView.setTextColor(textColor);
                textView.setText("0");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(BACKGROUND_COLOR_KEY, backgroundColor);
                editor.putInt(COUNTER_KEY, 0);
                editor.apply();
            }
        });

        buttonCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = sharedPreferences.getInt(COUNTER_KEY, 0);
                counter++;
                textView.setText(String.valueOf(counter));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(COUNTER_KEY, counter);
                editor.apply();
            }
        });





    }

}