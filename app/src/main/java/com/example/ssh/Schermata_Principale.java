package com.example.ssh;

import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;

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
import android.view.View;

public class Schermata_Principale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schermata_principale);
    }

    public void goto_Salute(View v){
        startActivity(new Intent(this, Activity_Salute.class));
    }

    public  void goto_Scuola(View v){
        startActivity(new Intent(this, Activity_Scuola.class));
    }

    public void Logout(View v){
        startActivity(new Intent(this, MainActivity.class));
    }



}