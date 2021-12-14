package com.example.ssh;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Avvisi_atutti extends AppCompatActivity { //sezione per scrivere un avviso a tutti gli insegnanti e genitori
    private EditText parent_name;
    private EditText object;
    private EditText data;
    private EditText contenuto;
    private Button invio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avvisiatutti);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_avvisi_atutti);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Compila avviso");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent_name = findViewById(R.id.Parent_name);
        object = findViewById(R.id.object);
        contenuto = findViewById(R.id.contenuto);
        data = findViewById(R.id.data);


        invio = (Button) findViewById(R.id.invia_avviso);
        invio.setClickable(false);

    }

    /*private boolean check_not_empty(){
        if(TextUtils.isEmpty( parent_name.getText().toString()) || TextUtils.isEmpty(object.getText().toString()) || TextUtils.isEmpty(contenuto.getText().toString())||TextUtils.isEmpty(data.getText().toString())){
            Toast.makeText(this,"Riempi i campi per inviare",Toast.LENGTH_LONG).show();
            return false;
        } else {
            invio.setClickable(true);
            return true;
        }*/
    }

