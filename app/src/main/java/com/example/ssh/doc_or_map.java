package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class doc_or_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_map_scelta);

        Toolbar toolbar = findViewById(R.id.toolbar_doc_mappa_sceltat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void goto_documento(View v){
        startActivity(
                new Intent(this, Documento.class)
        );
    }

    public void goto_mappa(View v){
        startActivity(
                new Intent(this, Mappa.class)
        );
    }



}