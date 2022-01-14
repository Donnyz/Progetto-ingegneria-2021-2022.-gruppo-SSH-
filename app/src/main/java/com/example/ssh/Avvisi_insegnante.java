package com.example.ssh;

import static com.example.ssh.MainActivity.BASE_URL;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Avvisi_insegnante extends AppCompatActivity { //sezione per scrivere un avviso ad uno specifico insegnante

    private EditText parent_name;
    private EditText object;
    private EditText data;
    private EditText contenuto;
    private EditText nomeinsegnante;
    private EditText cognomeinsegnante;
    private Button invio;
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisinsegnante);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_avvisi_insegnante);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Compila avviso");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent_name = findViewById(R.id.Parent_name);
        object = findViewById(R.id.object);
        contenuto = findViewById(R.id.contenuto);
        data = findViewById(R.id.data);
        nomeinsegnante = findViewById(R.id.nomeinsegnante);
        cognomeinsegnante = findViewById(R.id.cognomeinsegnante);
        if(!MainActivity.getP().getInsegna()){
            parent_name.setText(MainActivity.getP().getNome()+ " "+ MainActivity.getP().getCognome());
        }

        invio = (Button) findViewById(R.id.invia_avviso);
        invio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeinsegnante.getText().toString(), cognome = cognomeinsegnante.getText().toString(), oggetto = object.getText().toString(),descrizione=contenuto.getText().toString(),date = data.getText().toString(), id = MainActivity.getP().getId(),generale = "false",nomeBambino=parent_name.getText().toString();
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                retrofitInterface = retrofit.create(RetrofitInterface.class);
                Log.d("OGGETTO", oggetto);
                HashMap<String, String> map = new HashMap<>();
                map.put("nome", nome);
                map.put("cognome", cognome);
                map.put("oggetto", oggetto);
                map.put("descrizione", descrizione);
                map.put("id", id);
                map.put("generale", generale);
                map.put("data",date);
                map.put("nomeBambino",nomeBambino);
                Call<Void> call = retrofitInterface.executeInsAvvisi(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(Avvisi_insegnante.this, "INSERIMENTO EFFETTUATO", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(Avvisi_insegnante.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    /*private boolean check_not_empty(){
        if(TextUtils.isEmpty( parent_name.getText().toString()) || TextUtils.isEmpty(object.getText().toString()) || TextUtils.isEmpty(contenuto.getText().toString())||TextUtils.isEmpty(data.getText().toString())||
            TextUtils.isEmpty(nomeinsegnante.getText().toString())||TextUtils.isEmpty(cognomeinsegnante.getText().toString())){
                Toast.makeText(this,"Riempi i campi per inviare",Toast.LENGTH_LONG).show();
                return false;
            }else{
                invio.setClickable(true);
                return true;
            }
    }*/
}
