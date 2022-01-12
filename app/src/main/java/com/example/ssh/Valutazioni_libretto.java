package com.example.ssh;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
    private static String BASE_URL = "http://10.0.2.2:3000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valutazioni_libretto);

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
                Toast.makeText(Valutazioni_libretto.this,  response.body().get(0).getVoto(), Toast.LENGTH_LONG).show();
                Log.d("DIO", "CANE");
                for(Voto x: response.body())
                    Log.d("string",x.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Voto>> call, Throwable t) {
                Toast.makeText(Valutazioni_libretto.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
