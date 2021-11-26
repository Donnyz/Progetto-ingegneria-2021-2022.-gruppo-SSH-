package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Papprendimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papprendimento);
        Toolbar t = findViewById(R.id.toolbar_papprendimento);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Problemi Apprendimento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}