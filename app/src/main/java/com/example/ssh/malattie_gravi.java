package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class malattie_gravi extends AppCompatActivity {
    Intent extra;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malattie_gravi);
        Toolbar t = findViewById(R.id.toolbar_malattie_gravi);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Malattie Gravi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        extra = getIntent();
        p = utils.ottieni(extra);



    }
}