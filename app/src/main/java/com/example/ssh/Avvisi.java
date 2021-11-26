package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Avvisi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisi);

        //toolbar

        Toolbar toolbar = findViewById(R.id.toolbar_avvisi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Avvisi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}