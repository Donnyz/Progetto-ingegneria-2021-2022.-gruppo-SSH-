package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Libretto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libretto);

        //toolbar

        Toolbar toolbar = findViewById(R.id.toolbar_libretto);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Libretto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}