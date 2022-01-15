package com.example.ssh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Activity_Salute extends AppCompatActivity {
    Intent extra;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salute);

        extra = getIntent();
        p = utils.ottieni(extra);


        Toolbar t = findViewById(R.id.toolbar_salute);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Salute");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void goto_malattie_gravi(View v){
        if(p.getInsegna()) {
            startActivity(
                    utils.new_intent(p, malattie_gravi.class, getApplicationContext())
            );
        }else
            startActivity(utils.new_intent(
                    p,
                    Malattie_gravi_Genitori.class,
                    getApplicationContext()
            ));
    }

    public void goto_Papprendimento(View v){
        startActivity(
                utils.new_intent(p,
                        Papprendimento.class,
                        getApplicationContext())
        );
    }

    public void goto_Sstato_salute(View v){
        startActivity(
                utils.new_intent(p,
                        Stato_salute.class,
                        getApplicationContext())
        );

    }






}