package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Documento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento);

        Toolbar toolbar = findViewById(R.id.toolbar_documento);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Documeto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}