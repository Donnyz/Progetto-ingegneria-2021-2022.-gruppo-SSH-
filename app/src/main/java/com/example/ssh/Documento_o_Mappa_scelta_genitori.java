package com.example.ssh;

import static androidx.core.app.NotificationCompat.*;
import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Documento_o_Mappa_scelta_genitori extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    private Persona p;
    private Switch s;
    private GoogleMap mMap;
    private double latitute,longitude = 0.;
    private LatLng myposition;

    //swithc preference

    private static String myPref = "switch pref";
    private static String status_on = "status_on";
    private static String status_off = "status_off";

    boolean swithc_status;
    boolean on_status;
    SharedPreferences mypreference;
    SharedPreferences.Editor  myeditor;


    private Marker old = null;
    private LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documento_omappa_scelta_genitori);

        Toolbar toolbar = findViewById(R.id.toolbar_doc_mappa_scelta_gen);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Documento e Posizione");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        s = findViewById(R.id.switch1);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mypreference = getSharedPreferences(myPref,MODE_PRIVATE);
        myeditor = getSharedPreferences(myPref, MODE_PRIVATE).edit();

        swithc_status = mypreference.getBoolean(String.valueOf(swithc_status),false);
        on_status = mypreference.getBoolean(String.valueOf(on_status),false);

        s.setChecked(swithc_status);
        if(on_status){
            startService(Documento_o_Mappa_scelta_genitori.this);
        }
        else{
            stopService(Documento_o_Mappa_scelta_genitori.this);
        }

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(s.isChecked()){
                    myeditor.putBoolean(String.valueOf(swithc_status),true);
                    myeditor.putBoolean(String.valueOf(on_status),true);
                    myeditor.apply();
                    s.setChecked(true);


                    startService(Documento_o_Mappa_scelta_genitori.this);
                }
                else{
                    stopService(Documento_o_Mappa_scelta_genitori.this);
                    myeditor.putBoolean(String.valueOf(swithc_status),false);
                    myeditor.putBoolean(String.valueOf(on_status),false);
                    myeditor.apply();
                    s.setChecked(false);
                }
            }
        });

        createNotificationChannel();

    }





    public void startService(Context v){
        //invio posizione+persona da inserire


        Intent ServiceIntent = new Intent(this,Servizio_posizione.class);

        Toast.makeText(getApplicationContext(),"posCOndivisa dal servizio",Toast.LENGTH_SHORT).show();

        creaNotifica(Documento_o_Mappa_scelta_genitori.this,
                "Posizione condivisa con la scuola",
                "Clicca per interrompere la condivisione",
                R.drawable.ic_launcher_foreground);

        startService(ServiceIntent);


    }

    public void stopService(Documento_o_Mappa_scelta_genitori v){
        Intent ServiceIntent = new Intent(this,Servizio_posizione.class);
        Toast.makeText(getApplicationContext(),"fine servizio",Toast.LENGTH_SHORT).show();
        stopService(ServiceIntent);
    }



    public void goto_documento(View v){
        startActivity(
                new Intent(this, Documento.class)
        );
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        // da qui inviamo i dati
        latitute = location.getLatitude();
        longitude = location.getLongitude();

        myposition = new LatLng(latitute,longitude);
        if(old == null){
            old = mMap.addMarker(new MarkerOptions().position(myposition).title("nome persona").visible(true));
        }else{
            old.setVisible(false);
            old = mMap.addMarker(new MarkerOptions().position(myposition).title("nome persona").visible(true));
        }

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER ,0,0,Documento_o_Mappa_scelta_genitori.this);

    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel sc = new NotificationChannel(CHANNEL_ID, "prova", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager m = getSystemService(NotificationManager.class);
            m.createNotificationChannel(sc);

        }
    }
    public static void creaNotifica(Context c,String titolo,String contenuto,int icona){

        Intent result = new Intent(c.getApplicationContext(),Documento_o_Mappa_scelta_genitori.class);
        PendingIntent pResult = PendingIntent.getActivity(c.getApplicationContext(),1,result,PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder Builder = new Builder(c.getApplicationContext(),CHANNEL_ID);
        Builder.setContentTitle(titolo).
                setContentText(contenuto).
                setSmallIcon(icona)
                .setAutoCancel(true).
                setContentIntent(pResult);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(c.getApplicationContext());
        managerCompat.notify(1, Builder.build());

    }





    private class Servizio_posizione extends Service{

        @Override
        public void onCreate() {
            super.onCreate();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            return START_NOT_STICKY;
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

    }

}