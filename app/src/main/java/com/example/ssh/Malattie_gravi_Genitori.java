package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Malattie_gravi_Genitori extends AppCompatActivity {
    private Button info_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malattie_gravi_genitori);
        info_add = findViewById(R.id.aggiungi_info_malattia);

    }

    public void next(View v){
            startActivity(new Intent(this, add_Malattia.class));
        }

}