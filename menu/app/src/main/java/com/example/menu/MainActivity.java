package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String message = item.toString();
        switch (item.getItemId()) {
            case R.id.option_settings:
            case R.id.option_favourites:
            case R.id.sub_option_email:
            case R.id.sub_option_phone:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "You clicked menu item " + message);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}