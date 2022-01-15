package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add_problemiApprendimento extends AppCompatActivity {

    private EditText azione;
    private EditText ipotesi;
    private EditText gravità;
    private Button add;
    Intent extra;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problemi_apprendimento);

        azione = findViewById(R.id.Azione);
        ipotesi = findViewById(R.id.ipotesi);
        gravità = findViewById(R.id.gravità);
        add = findViewById(R.id.add);
        extra = getIntent();
        p = utils.ottieni(extra);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();

                map.put("id",MainActivity.getP().getId());
                map.put("azione",azione.getText().toString());
                map.put("ipotesi",ipotesi.getText().toString());
                map.put("gravita",gravità.getText().toString());
                Call<Void> call = MainActivity.retrofitInterface.executeInsProblema(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(add_problemiApprendimento.this, "Problema di Apprendimento inserito", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(add_problemiApprendimento.this,  t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public void segnala_problema(View view){

    }
}