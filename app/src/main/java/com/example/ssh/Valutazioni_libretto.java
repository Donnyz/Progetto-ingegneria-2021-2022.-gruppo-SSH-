package com.example.ssh;

import static com.example.ssh.MainActivity.BASE_URL;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.ListView;

import android.widget.Toast;

import android.widget.ArrayAdapter;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Valutazioni_libretto extends AppCompatActivity {

    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;

    Intent extra;
    Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valutazioni_libretto);

        extra = getIntent();
        persona = utils.ottieni(extra);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_valutazioni_libretto);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Valutazioni");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Gson gson = new GsonBuilder().setLenient().create();


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("nome",MainActivity.getP().getNome());
        map.put("cognome",MainActivity.getP().getCognome());
        Call<ArrayList<Voto>> call = retrofitInterface.executeVoti(map);

        call.enqueue(new Callback<ArrayList<Voto>>() {
            @Override
            public void onResponse(Call<ArrayList<Voto>> call, Response<ArrayList<Voto>> response) {

                //listview
                ListView Mylist = (ListView) findViewById(R.id.listView1);
                ArrayList<String> voti = new ArrayList<String>();
                for(int i=0; i<response.body().size();i++){
                    voti.add(response.body().get(i).getData() + "\n" +response.body().get(i).getMateria() + ":  " +response.body().get(i).getVoto());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,voti);
                Mylist.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Voto>> call, Throwable t) {
                Toast.makeText(Valutazioni_libretto.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
