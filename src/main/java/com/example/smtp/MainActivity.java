package com.example.smtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText inp_aantalKist;
    private Button btn_bereken;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bereken = findViewById(R.id.btn_bereken);
        inp_aantalKist = findViewById(R.id.inp_aantalKisten);
        //Key-presses
        btn_bereken.setOnClickListener(view -> {

            //Instance of mail service activity
            smtp ms = new smtp(inp_aantalKist.getText().toString() );
            ms.execute();
            inp_aantalKist.setText("");


        });
    }
}