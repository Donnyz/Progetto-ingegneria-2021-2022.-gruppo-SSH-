package com.example.ssh;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static androidx.core.app.NotificationCompat.*;
import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class Documento_o_Mappa_scelta_genitori extends AppCompatActivity  {
    private Persona p;
    private Switch s;
    private GoogleMap mMap;
    private double latitute, longitude = 0.;
    private LatLng myposition;

    //swithc preference

    private final static String myPref = "switch pref";
    private final static String status = "status";
    private boolean swithc_status;

    SharedPreferences mypreference;
    SharedPreferences.Editor myeditor;

    private static final int REQUEST_CODE_LOCATION_PERMISSION =1;

    //position
    PeriodicWorkRequest periodicWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_omappa_scelta_genitori);


        Toolbar toolbar = findViewById(R.id.toolbar_doc_mappa_scelta_gen);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Documento e Posizione");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        s = findViewById(R.id.switch1);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startLocationService();
                }
                else {
                    stopLocationService();
                }
            }
        });



    }

    private boolean isLocationServiceRunning(){
        ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if(activityManager!=null){
            for(ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)){
                if(locationService.class.getName().equals(service.service.getClassName())){
                    if(service.foreground){
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private void startLocationService(){
        if(!isLocationServiceRunning()){
            Intent intent = new Intent(getApplicationContext(), locationService.class);
            intent.setAction(costants.Action_start_location_service);
            startService(intent);
        }

    }

    private void stopLocationService(){
        if(isLocationServiceRunning()){
            Intent intent = new Intent(getApplicationContext(),locationService.class);
            intent.setAction(costants.Action_stop_location_service);
            startService(intent);
        }
    }





    public void saveData() {
        mypreference = getSharedPreferences(myPref, MODE_PRIVATE);
        myeditor = getSharedPreferences(myPref, MODE_PRIVATE).edit();
        myeditor.putBoolean(status, s.isChecked());
        myeditor.apply();
    }

    public void loadData() {
        mypreference = getSharedPreferences(myPref, MODE_PRIVATE);
        myeditor = getSharedPreferences(myPref, MODE_PRIVATE).edit();
        swithc_status = mypreference.getBoolean(status, false);
    }

    public void updateViews() {
        s.setChecked(swithc_status);

    }


    public void goto_documento(View v) {
        startActivity(
                new Intent(this, Documento.class)
        );
    }


    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel sc = new NotificationChannel(CHANNEL_ID, "prova", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager m = getSystemService(NotificationManager.class);
            m.createNotificationChannel(sc);

        }
    }


    public static void creaNotifica(Context c, String titolo, String contenuto, int icona) {

        Intent result = new Intent(c.getApplicationContext(), Documento_o_Mappa_scelta_genitori.class);
        PendingIntent pResult = PendingIntent.getActivity(c.getApplicationContext(), 1, result, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder Builder = new Builder(c.getApplicationContext(), CHANNEL_ID);
        Builder.setContentTitle(titolo).
                setContentText(contenuto).
                setSmallIcon(icona)
                .setAutoCancel(true).
                setContentIntent(pResult);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(c.getApplicationContext());
        managerCompat.notify(1, Builder.build());

    }


}