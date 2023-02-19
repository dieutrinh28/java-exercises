package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btn = findViewById(R.id.btn_play);
//        String buttonName = btn.getText().toString();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ShowInformationActivity.class);
//                intent.putExtra("buttonName", buttonName);
//                startActivity(intent);
//            }
//        });

    }

    public void onShowInformation(View view) {
        Button button = (Button) view;
        String buttonName = button.getText().toString();

        Intent intent = new Intent(getApplicationContext(), ShowInformationActivity.class);
        intent.putExtra("buttonName", buttonName);
        startActivity(intent);
    }
}