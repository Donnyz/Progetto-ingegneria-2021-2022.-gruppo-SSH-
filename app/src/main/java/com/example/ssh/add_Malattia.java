package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add_Malattia extends AppCompatActivity {
    private EditText nome_mal;
    private EditText info_mal;
    private EditText numero;
    private Button aggiungi_info;
    Intent extra;
    Persona p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_add_malattia);
        nome_mal = findViewById(R.id.nome_malattia);
        info_mal = findViewById(R.id.info_Malattia);
        numero = findViewById(R.id.numerodaChiamare);
        aggiungi_info = findViewById(R.id.add);
        extra = getIntent();
        p = utils.ottieni(extra);
        aggiungi_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();
                map.put("id",p.getId());
                map.put("nome",nome_mal.getText().toString());
                map.put("numero",numero.getText().toString());
                map.put("descrizione",info_mal.getText().toString());
                Call<Void> call = MainActivity.retrofitInterface.executeInsMalattia(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(add_Malattia.this, "Malattia inserita", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(add_Malattia.this,  t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });




    }

    private void registra_malattia(View v){

    }
}