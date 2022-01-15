package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sezione_avvisi extends AppCompatActivity {

    Intent extra;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisi);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_avvisi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Avvisi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extra =getIntent();
        persona  = utils.ottieni(extra);
    }

    public void goto_avvisiPerMe(View view){
        startActivity(utils.new_intent(persona, Condivisi_con_me.class,getApplicationContext()));
    }

    public void goto_avvisiPerTutti(View view){
        startActivity(utils.new_intent(persona,Avvisi_atutti.class,getApplicationContext()));
    }

    public void goto_avvisiPerProf(View view){
        startActivity(utils.new_intent(persona,Avvisi_insegnante.class,getApplicationContext()));
    }
}