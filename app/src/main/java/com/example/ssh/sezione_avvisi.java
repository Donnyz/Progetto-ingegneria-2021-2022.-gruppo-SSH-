package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sezione_avvisi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisi);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_avvisi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Avvisi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goto_avvisiPerMe(View view){
        startActivity(new Intent(this,Condivisi_con_me.class));
    }

    public void goto_avvisiPerTutti(View view){
        startActivity(new Intent(this,Avvisi_atutti.class));
    }

    public void goto_avvisiPerProf(View view){
        startActivity(new Intent(this,Avvisi_insegnante.class));
    }
}