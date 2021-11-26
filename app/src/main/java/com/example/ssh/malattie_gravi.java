package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class malattie_gravi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malattie_gravi);
        Toolbar t = findViewById(R.id.toolbar_malattie_gravi);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Malattie Gravi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}