package com.example.ssh;

import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;
import com.example.ssh.MainActivity.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Schermata_Principale extends AppCompatActivity {
    private Intent extra;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schermata_principale);
        extra = getIntent();
        persona = utils.ottieni(extra);

    }

    public void goto_Salute(View v){
        startActivity(utils.new_intent(persona,Activity_Salute.class,getApplicationContext()));
    }

    public  void goto_Scuola(View v){
        startActivity(utils.new_intent(persona,Activity_Scuola.class,getApplicationContext()));
    }

    public void Logout(View v){
        startActivity(utils.new_intent(null,MainActivity.class,getApplicationContext()));
    }



}