package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Papprendimento extends AppCompatActivity {
    Intent extra;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papprendimento);
        Toolbar t = findViewById(R.id.toolbar_papprendimento);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Problemi Apprendimento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extra = getIntent();
        p = utils.ottieni(extra);

    }

    public void add_problemiDiApprendimento(View v){
        startActivity(new Intent(this,add_problemiApprendimento.class));
    }

}