package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText editText_name;
    EditText editText_phone;
    Switch aSwitch_gender;
    Spinner spinner_education;
    SeekBar seekBar_age;
    CheckBox checkBox_sports;
    RadioButton rdBtnRock;
    RadioButton rdBtnRap;
    RadioButton rdBtnPop;

    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.name_field);
        editText_phone = findViewById(R.id.phone_field);
        aSwitch_gender = findViewById(R.id.gender_field);

        spinner_education = findViewById(R.id.education_field);
        String[] values = new String[]{"Cao đẳng", "Đại học", "Cao học"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_education.setAdapter(adapter);

        seekBar_age = findViewById(R.id.age_field);
        checkBox_sports = findViewById(R.id.sports_field);
        rdBtnRock = findViewById(R.id.rock_music_field);
        rdBtnRap = findViewById(R.id.rap_music_field);
        rdBtnPop = findViewById(R.id.pop_music_field);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText_name.getText().toString();
                String phone = editText_phone.getText().toString();
                String gender = "";
                if(aSwitch_gender.isChecked()) {
                    gender="Nữ";
                }
                else {
                    gender = "Nam";
                };
                String education = spinner_education.getSelectedItem().toString();
                int age = seekBar_age.getProgress();
                String sports = "";
                if(checkBox_sports.isChecked()) {
                    sports = "Có";
                }
                else {
                    sports = "Không";
                };
                String music = "";
                if (rdBtnPop.isChecked()) {
                    music = "Pop";
                } else if (rdBtnRap.isChecked()) {
                    music = "Rap";
                } else if (rdBtnRock.isChecked()) {
                    music = "Rock";
                }

                User user = new User(name, phone, gender, education, age, sports, music);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("gender", gender);
                intent.putExtra("education", education);
                intent.putExtra("age", age);
                intent.putExtra("sports", sports);
                intent.putExtra("music", music);
                startActivity(intent);
            }
        });
    }
}