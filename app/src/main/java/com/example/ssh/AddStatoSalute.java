package com.example.ssh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStatoSalute extends AppCompatActivity{
    private EditText nome_ragazzo;
    private EditText descrizione;
    private EditText ora;
    private Button aggiungi_stato;
    Intent extra;
    Persona p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_statosalute);
        Toolbar t = findViewById(R.id.toolbar_aggiungi_stato);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Aggiungi Stato Salute");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nome_ragazzo = findViewById(R.id.nome_ragazzo);
        descrizione = findViewById(R.id.info_Malattia);
        ora = findViewById(R.id.ora);
        aggiungi_stato = findViewById(R.id.add);
        extra = getIntent();
        p = utils.ottieni(extra);
        aggiungi_stato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();
                map.put("id",MainActivity.getP().getId());
                map.put("nome",nome_ragazzo.getText().toString());
                map.put("ora",ora.getText().toString());
                map.put("descrizione",descrizione.getText().toString());
                Call<Void> call = MainActivity.retrofitInterface.executeInsMalattia(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(AddStatoSalute.this, "Stato salute inserito", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(AddStatoSalute.this,  t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                startActivity(utils.new_intent(p,Stato_salute.class,getApplicationContext()));
            }
        });
    }

    private void registra_stato(View v){

    }
}
