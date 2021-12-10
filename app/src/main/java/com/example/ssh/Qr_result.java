package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Qr_result extends AppCompatActivity {
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_result);
        TextView t = findViewById(R.id.Result_qr);
        Intent intent = getIntent();
        result = intent.getStringExtra(Documento.EXTRA_TEXT);
        t.setText(result);

    }
}