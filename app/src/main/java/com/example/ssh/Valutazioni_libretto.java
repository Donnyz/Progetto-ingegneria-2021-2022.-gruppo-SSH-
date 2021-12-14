package com.example.ssh;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Valutazioni_libretto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valutazioni_libretto);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_valutazioni_libretto);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Valutazioni");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
