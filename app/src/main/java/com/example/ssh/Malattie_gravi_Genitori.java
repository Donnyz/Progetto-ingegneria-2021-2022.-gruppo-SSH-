package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Malattie_gravi_Genitori extends AppCompatActivity {
    private Button info_add;
    Intent extra;
    Persona p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malattie_gravi_genitori);
        info_add = findViewById(R.id.aggiungi_info_malattia);

        extra = getIntent();
        p = utils.ottieni(extra);
        HashMap<String, String> map = new HashMap<>();
        map.put("id",p.getId());
        Call<ArrayList<Malattia>> call = MainActivity.retrofitInterface.executeMalattia(map);
        call.enqueue(new Callback<ArrayList<Malattia>>() {
            @Override
            public void onResponse(Call<ArrayList<Malattia>> call, Response<ArrayList<Malattia>> response) {
                Toast.makeText(Malattie_gravi_Genitori.this,  response.body().get(0).getNome(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Malattia>> call, Throwable t) {
                Toast.makeText(Malattie_gravi_Genitori.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void next(View v){
            startActivity(utils.new_intent(p,add_Malattia.class,getApplicationContext()));
        }

}