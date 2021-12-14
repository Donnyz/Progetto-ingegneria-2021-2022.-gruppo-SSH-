package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


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

    public void goto_valutazioni(View view){
        startActivity(new Intent(this,Valutazioni_libretto.class));
    }

    public void goto_note(View view){

        startActivity(new Intent(this,Note_libretto.class));
    }
}