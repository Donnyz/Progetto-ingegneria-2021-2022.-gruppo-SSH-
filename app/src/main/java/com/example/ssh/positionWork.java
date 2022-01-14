package com.example.ssh;

import
        static com.example.ssh.Documento_o_Mappa_scelta_genitori.creaNotifica;
import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;
import static com.example.ssh.Documento_o_Mappa_scelta_genitori.*;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class positionWork extends Worker {


    Location l;

    positionWork(Context c, WorkerParameters p){
        super(c,p);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data data = getInputData();
       double latitude = data.getDouble("latitude",0.);
        double longitude = data.getDouble("longitude",0.);


        Log.d("latitudine", "lat = "+latitude);
        Log.d("longitudine", "long = "+longitude);

        return Result.success();
    }
}

