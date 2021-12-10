package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Button b = (Button) findViewById(R.id.button);
    }

    public void onClick(View view){
        startActivity(new Intent(this,Qr_Reader.class));
    }
}