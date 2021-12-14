package com.example.ssh;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Condivisi_con_me extends AppCompatActivity { //sezione per avvisi condivisi con me da parte degli insegnanti o altri genitori
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisiperme);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_avvisi_perme);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Avvisi condivisi con me");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
