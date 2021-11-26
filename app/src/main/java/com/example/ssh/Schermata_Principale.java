package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Schermata_Principale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schermata_principale);
    }

    public void goto_Salute(View v){
        startActivity(new Intent(this, Activity_Salute.class));
    }

    public  void goto_Scuola(View v){
        startActivity(new Intent(this, Activity_Scuola.class));
    }

    public void Logout(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

}