package com.example.ssh;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Avvisi_insegnante extends AppCompatActivity { //sezione per scrivere un avviso ad uno specifico insegnante

    private EditText parent_name;
    private EditText object;
    private EditText data;
    private EditText contenuto;
    private EditText nomeinsegnante;
    private EditText cognomeinsegnante;
    private Button invio;

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


        invio = (Button) findViewById(R.id.invia_avviso);
        invio.setClickable(false);
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
