package com.example.ssh;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.VIBRATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;





public class MainActivity extends AppCompatActivity {




    protected static String BASE_URL = "http://10.0.2.2:3000";
    public static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    public static RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
    private static Persona p = new Persona();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().setLenient().create();

        if (checkPermission()) {
            // if permission is already granted display a toast message
            Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
        } else
            requestPermission();
        Button loginBtn = findViewById(R.id.Login);
        EditText nome = findViewById(R.id.editTextTextEmailAddress);
        EditText cognome = findViewById(R.id.editTextTextPassword);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();
                map.put("username",nome.getText().toString());
                map.put("password",cognome.getText().toString());
                Call<LoginResult> call = retrofitInterface.executeLogin(map);
                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if(response.code()==200){
                            Toast.makeText(MainActivity.this, "Login effettuato", Toast.LENGTH_LONG).show();
                            p.setCognome(response.body().getCognome());
                            p.setNome(response.body().getNome());
                            p.setId(response.body().getId());
                            p.setInsegna(response.body().getInsegna());
                            Intent persona = utils.new_intent(p,Schermata_Principale.class,getApplicationContext());
                            startActivity(persona);

                        }else {
                            Toast.makeText(MainActivity.this, "Credenziali errate", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        System.out.println(t.getMessage());
                        Toast.makeText(MainActivity.this,  t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }

    public static Persona getP(){
        return p;
    }
    public static RetrofitInterface getRetrofitInterface(){
        return retrofitInterface;
    }

    public boolean checkPermission() {
        int camera_permission = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int vibrate_permission = ContextCompat.checkSelfPermission(getApplicationContext(), VIBRATE);
        int fine_permission = ContextCompat.checkSelfPermission(getApplicationContext(),ACCESS_FINE_LOCATION);
        int coarse_permission = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);
        int externalStorageW = ContextCompat.checkSelfPermission(getApplicationContext(),WRITE_EXTERNAL_STORAGE);
        int externalStorager = ContextCompat.checkSelfPermission(getApplicationContext(),READ_EXTERNAL_STORAGE);

        return camera_permission == PackageManager.PERMISSION_GRANTED && vibrate_permission == PackageManager.PERMISSION_GRANTED && PackageManager.PERMISSION_GRANTED == externalStorageW &&
                  externalStorager == PackageManager.PERMISSION_GRANTED && fine_permission == PackageManager.PERMISSION_GRANTED && coarse_permission == PackageManager.PERMISSION_GRANTED;

    }


    public void requestPermission() {
        int PERMISSION_REQUEST_CODE = 200;

        ActivityCompat.requestPermissions(this, new String[]{CAMERA,ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION,WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // this method is called when user
        // allows the permission to use camera.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            for(int i = 0; i<grantResults.length;i++) {
                boolean cameraaccepted = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                boolean fine_accepted = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                boolean externa = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                boolean coarse_accepted = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                boolean externalR = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                if (cameraaccepted && fine_accepted && externalR && coarse_accepted && externa) {
                    Toast.makeText(this, "Permission granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denined \n You cannot use app without providing permission", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void next(View v){
        startActivity(new Intent(this, Schermata_Principale.class));
    }



    public class Notf_channel extends Application{
        public static final String CHANNEL_ID = "channelid";

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate();
            createNotificationChannel();
        }

        public void createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel sc = new NotificationChannel(CHANNEL_ID, "prova", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager m = getSystemService(NotificationManager.class);
                m.createNotificationChannel(sc);

            }
        }

    }
}


