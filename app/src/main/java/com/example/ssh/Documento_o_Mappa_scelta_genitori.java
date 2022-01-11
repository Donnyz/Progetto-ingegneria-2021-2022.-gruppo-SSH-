package com.example.ssh;

import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
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
    View actual;

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

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(s.isChecked()){
                    startService(Documento_o_Mappa_scelta_genitori.this);
                }
                else{
                    stopService(Documento_o_Mappa_scelta_genitori.this);
                }
            }
        });


    }



    public void startService(Documento_o_Mappa_scelta_genitori v){

        Intent ServiceIntent = new Intent(this,Servizio_posizione.class);
        Toast.makeText(getApplicationContext(),"posCOndivisa dal servizio",Toast.LENGTH_SHORT).show();
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
            Intent nofiticationIntent = new Intent(this,Documento_o_Mappa_scelta_genitori.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,nofiticationIntent,0);
            Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                    .setContentTitle("pos_condivisa")
                    .setContentText("prova")
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .build();
            startForeground(1,notification);

            return START_NOT_STICKY;
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

    }

}