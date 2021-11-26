package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Stato_salute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stato_salute);
        Toolbar t = findViewById(R.id.toolbar_stato_salute);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Stato Salute");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}