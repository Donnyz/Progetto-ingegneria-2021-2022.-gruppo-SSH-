package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_problemiApprendimento extends AppCompatActivity {

    private EditText azione;
    private EditText ipotesi;
    private EditText gravità;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problemi_apprendimento);

        azione = findViewById(R.id.Azione);
        ipotesi = findViewById(R.id.ipotesi);
        gravità = findViewById(R.id.gravità);
        add = findViewById(R.id.add);
    }

    public void segnala_problema(View view){

    }
}