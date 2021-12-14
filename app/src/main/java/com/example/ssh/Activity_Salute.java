package com.example.ssh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Activity_Salute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salute);
        Toolbar t = findViewById(R.id.toolbar_salute);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Salute");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goto_malattie_gravi(View v){
        startActivity(
                new Intent(this, malattie_gravi.class)
        );

    }

    public void goto_Papprendimento(View v){
        startActivity(
                new Intent(this, Papprendimento.class)
        );
    }

    public void goto_Sstato_salute(View v){
        startActivity(
                new Intent(this, Stato_salute.class)
        );
    }






}