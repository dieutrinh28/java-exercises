package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvName;
    ArrayList<String> arrayName;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        lvName = findViewById(R.id.list_view);
        arrayName = new ArrayList<>();
        addArrayName();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayName);
        lvName.setAdapter(adapter);

        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onClickShowAlertDialog(i);

            }
        });
    }

    public void onClickShowAlertDialog(int position) {
        String name = arrayName.get(position).toString();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SecondActivity.this);
        alertDialog.setTitle("You selected " + name);
        alertDialog.setMessage("Are you want to continue?");
        alertDialog.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String success = "Continue success";
                Toast.makeText(getApplicationContext(), success, Toast.LENGTH_SHORT).show();
            }
        });
           alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

               }
           });

           AlertDialog dialog = alertDialog.create();
           dialog.show();

    }
    private void addArrayName() {
        arrayName.add("PHP");
        arrayName.add("C#");
        arrayName.add("Javascript");
        arrayName.add("Java");
        arrayName.add("Flutter");
        arrayName.add("ReactJS");
        arrayName.add("Git");
        arrayName.add("Figma");

    }
}