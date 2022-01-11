package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class add_Malattia extends AppCompatActivity {
    private EditText nome_mal;
    private EditText info_mal;
    private EditText numero;
    private Button aggiungi_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_add_malattia);
        nome_mal = findViewById(R.id.nome_malattia);
        info_mal = findViewById(R.id.info_Malattia);
        numero = findViewById(R.id.numerodaChiamare);
        aggiungi_info = findViewById(R.id.add);


    }

    private void registra_malattia(){}
}