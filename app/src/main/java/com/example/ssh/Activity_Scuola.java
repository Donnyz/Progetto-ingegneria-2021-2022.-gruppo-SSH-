package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class Activity_Scuola extends AppCompatActivity {

    Intent extra;
    Persona p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scuola);

        //toolbar

        Toolbar toolbar = findViewById(R.id.toolbar_scuola);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scuola");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extra = getIntent();
        p = utils.ottieni(extra);
    }

    public void goto_Doc_mappa(View v) {

        if(MainActivity.getP().getInsegna()){
            startActivity(
                    utils.new_intent(p,Documento_o_Mappa_Scelta_professori.class,getApplicationContext())
            );
        }
        else{
            startActivity(utils.new_intent(p,Documento_o_Mappa_scelta_genitori.class,getApplicationContext()));
        }
    }

    public void goto_Avvisi(View v){
        startActivity(
        utils.new_intent(p,sezione_avvisi.class,getApplicationContext())
        );
    }
    public void goto_Libretto(View v){
        startActivity(utils.new_intent(p,Libretto.class,getApplicationContext()));
    }


}