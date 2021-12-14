package com.example.ssh;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Note_libretto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_note_libretto);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Note Disciplinari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
