package com.example.ssh;

import static com.example.ssh.MainActivity.BASE_URL;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Note_libretto extends AppCompatActivity {
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_note_libretto);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Note Disciplinari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("nome",MainActivity.getP().getNome());
        map.put("cognome",MainActivity.getP().getCognome());

        Call<ArrayList<Nota>> call = retrofitInterface.executeNote(map);
        call.enqueue(new Callback<ArrayList<Nota>>() {
            @Override
            public void onResponse(Call<ArrayList<Nota>> call, Response<ArrayList<Nota>> response) {

                //listview
                ListView Mylist = (ListView) findViewById(R.id.listView1);
                ArrayList<String> note = new ArrayList<String>();

                for(int i=0; i<response.body().size();i++){
                    note.add(response.body().get(i).getData() + "\n" +response.body().get(i).getInsegnante() + ":  " +response.body().get(i).getDescrizione());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,note);
                Mylist.setAdapter(adapter);

                /*ArrayList<Nota> note= response.body();
                Log.d("DIO", "DIOCANE");
                Call<ArrayList<Persona>> call2 = retrofitInterface.executeInsegnante();
                call2.enqueue(new Callback<ArrayList<Persona>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Persona>> call, Response<ArrayList<Persona>> risposta) {

                        for (Persona x: risposta.body()){
                            for(Nota n: note){
                                if(n.getInsegnante()==x.getId()){
                                    n.setInsegnante(x.getNome() + " " +x.getCognome());
                                }
                            }
                        }*/
                        //Toast.makeText(Note_libretto.this,  note.get(0).getInsegnante(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Nota>> call, Throwable t) {
                Toast.makeText(Note_libretto.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
                    /*@Override
                    public void onFailure(Call<ArrayList<Persona>> call, Throwable t) {
                        Log.d("Errore",t.getMessage());
                        Toast.makeText(Note_libretto.this,  t.getMessage(), Toast.LENGTH_LONG).show();
                    }*/
        });
    }
}
