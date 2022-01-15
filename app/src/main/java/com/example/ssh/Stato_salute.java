package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Stato_salute extends AppCompatActivity {

    Intent extra;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stato_salute);
        Toolbar t = findViewById(R.id.toolbar_stato_salute);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Stato Salute");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extra = getIntent();

        p = utils.ottieni(extra);
        HashMap<String, String> map = new HashMap<>();
        map.put("id",MainActivity.getP().getId());
        map.put("insegna",MainActivity.getP().getInsegna()+"");
        Call<ArrayList<StatoSalute>> call = MainActivity.retrofitInterface.executeStato(map);
        call.enqueue(new Callback<ArrayList<StatoSalute>>() {
            @Override
            public void onResponse(Call<ArrayList<StatoSalute>> call, Response<ArrayList<StatoSalute>> response) {
                Toast.makeText(Stato_salute.this, response.body().get(0).getDescrizione(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<StatoSalute>> call, Throwable t) {
                Toast.makeText(Stato_salute.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}