package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Stato_salute extends AppCompatActivity {

    Intent extra;
    Persona p;
    private Button add_stato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stato_salute);
        Toolbar t = findViewById(R.id.toolbar_stato_salute);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Stato Salute");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        add_stato = findViewById(R.id.addStato);

        extra = getIntent();

        p = utils.ottieni(extra);
        HashMap<String, String> map = new HashMap<>();
        map.put("id",MainActivity.getP().getId());
        map.put("insegna",MainActivity.getP().getInsegna()+"");
        Call<ArrayList<StatoSalute>> call = MainActivity.retrofitInterface.executeStato(map);
        call.enqueue(new Callback<ArrayList<StatoSalute>>() {
            @Override
            public void onResponse(Call<ArrayList<StatoSalute>> call, Response<ArrayList<StatoSalute>> response) {
                //listview
                ListView Mylist = (ListView) findViewById(R.id.listView1);
                ArrayList<String> StatoSalute = new ArrayList<String>();
                for(int i=0; i<response.body().size();i++){
                    StatoSalute.add(response.body().get(i).getOra() + "\n" +response.body().get(i).getNome() + ":  " +response.body().get(i).getDescrizione());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,StatoSalute);
                Mylist.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<StatoSalute>> call, Throwable t) {
                Toast.makeText(Stato_salute.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void nuovo_stato(View v){
        startActivity(utils.new_intent(p,AddStatoSalute.class,getApplicationContext()));
    }
}