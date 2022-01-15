package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Documento_o_Mappa_Scelta_professori extends AppCompatActivity {
    Intent extra;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_map_scelta_prof);


        //toolbar

        Toolbar toolbar = findViewById(R.id.toolbar_doc_mappa_sceltat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scegli tra Documento o mappa ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extra = getIntent();
        persona = utils.ottieni(extra);
    }

    public void goto_documento(View v){
        startActivity(
                new Intent(this, Qr_Reader.class)
        );
    }

    public void goto_mappa(View v){
        startActivity(
                new Intent(this, Mappa.class)
        );
    }
}