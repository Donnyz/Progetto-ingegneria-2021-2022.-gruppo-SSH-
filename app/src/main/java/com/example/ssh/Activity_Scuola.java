package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Scuola extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scuola);

        //toolbar

        Toolbar toolbar = findViewById(R.id.toolbar_scuola);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scuola");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goto_Doc_mappa(View v){
        /*
        if(persona.getRuolo() == "Professore") {
            startActivity(
                    new Intent(this, Documento_o_Mappa_Scelta_professori.class)
            );
        }
        else
        {
         */

        startActivity(
                    new Intent(this, Documento_o_Mappa_scelta_genitori.class)
            );
        }
    //}

    public void goto_Avvisi(View v){
        startActivity(
                new Intent(this, Avvisi.class)
        );
    }
    public void goto_Libretto(View v){
        startActivity(
                new Intent(this, Libretto.class)
        );
    }


}