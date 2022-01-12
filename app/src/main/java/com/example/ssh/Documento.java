package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Documento extends AppCompatActivity {

    public  static final String EXTRA_TEXT= "com.example.ssh.";

    private EditText parent_name;
    private EditText other_name;
    private EditText other_lastname;
    private EditText data;
    String sGenerator;
    private Button sendGeneretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento);

        Toolbar toolbar = findViewById(R.id.toolbar_documento);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Compila Documento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent_name = findViewById(R.id.Parent_name);
        other_name = findViewById(R.id.other_name);
        other_lastname= findViewById(R.id.other_lastname);
        data = findViewById(R.id.Data);


        sendGeneretor = (Button) findViewById(R.id.send_generator);
        sendGeneretor.setClickable(false);

        sendGeneretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_not_empty())
                    openQrActivity();
            }
        });
    }


    public  void openQrActivity(){
        Intent intent = new Intent(this,Qr_generator.class);


            sGenerator ="Il/La sottoscritta " + parent_name.getText().toString() + "\n" +
                    "autorizzo il/la signor* " + other_name.getText().toString() + " " + other_lastname.getText().toString() + "\n " +
                    "a ritirare mio figlio da scuola il giorno " + data.getText().toString();

            intent.putExtra(EXTRA_TEXT, sGenerator);
            startActivity(intent);
        }

    private boolean check_not_empty(){
        if(TextUtils.isEmpty( parent_name.getText().toString()) || TextUtils.isEmpty(other_name.getText().toString()) || TextUtils.isEmpty(other_lastname.getText().toString())||TextUtils.isEmpty(data.getText().toString())){
            Toast.makeText(this,"Riempi i campi per generare il qr Code",Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            sendGeneretor.setClickable(true);
            return true;
        }
    }


}