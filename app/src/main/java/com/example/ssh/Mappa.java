package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Mappa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mappa);
        Toolbar toolbar = findViewById(R.id.toolbar_mappa);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mappa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}