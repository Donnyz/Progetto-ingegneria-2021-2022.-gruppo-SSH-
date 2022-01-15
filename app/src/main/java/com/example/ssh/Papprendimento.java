package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Papprendimento extends AppCompatActivity {
    Intent extra;
    Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papprendimento);
        Toolbar t = findViewById(R.id.toolbar_papprendimento);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Problemi Apprendimento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        extra = getIntent();
        p = utils.ottieni(extra);
        HashMap<String, String> map = new HashMap<>();
        map.put("id",p.getId());
        Call<ArrayList<ProblemaApprendimento>> call = MainActivity.retrofitInterface.executeProblema(map);
        call.enqueue(new Callback<ArrayList<ProblemaApprendimento>>() {
            @Override
            public void onResponse(Call<ArrayList<ProblemaApprendimento>> call, Response<ArrayList<ProblemaApprendimento>> response) {
                Toast.makeText(Papprendimento.this,  response.body().get(0).getAzione(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<ProblemaApprendimento>> call, Throwable t) {
                Toast.makeText(Papprendimento.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void add_problemiDiApprendimento(View v){
        startActivity(new Intent(this,add_problemiApprendimento.class));
    }

}