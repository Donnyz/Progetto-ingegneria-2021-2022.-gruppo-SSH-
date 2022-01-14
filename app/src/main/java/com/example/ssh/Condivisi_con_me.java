package com.example.ssh;

import static com.example.ssh.MainActivity.BASE_URL;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Condivisi_con_me extends AppCompatActivity { //sezione per avvisi condivisi con me da parte degli insegnanti o altri genitori
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisiperme);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_avvisi_perme);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Avvisi condivisi con me");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Gson gson = new GsonBuilder().setLenient().create();


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("id",MainActivity.getP().getId());
        Call<ArrayList<Avviso>> call = retrofitInterface.executeAvviso(map);

        call.enqueue(new Callback<ArrayList<Avviso>>() {
            @Override
            public void onResponse(Call<ArrayList<Avviso>> call, Response<ArrayList<Avviso>> response) {

                //listview
                ListView Mylist = (ListView) findViewById(R.id.listView1);
                ArrayList<String> avvisi = new ArrayList<String>();
                for(int i=0; i<response.body().size();i++){
                    avvisi.add(response.body().get(i).getData() + "\n" +response.body().get(i).getOggetto() + ":  " +response.body().get(i).getDescrizione());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,avvisi);
                Mylist.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Avviso>> call, Throwable t) {
                Toast.makeText(Condivisi_con_me.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
