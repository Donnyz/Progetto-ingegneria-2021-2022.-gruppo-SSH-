package com.example.ssh;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.VIBRATE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
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
    private static Retrofit retrofit;
    private static RetrofitInterface retrofitInterface;
    private static String BASE_URL = "http://10.0.2.2:3000";
    private static Persona p = new Persona();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
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
                map.put("nome",nome.getText().toString());
                map.put("cognome",cognome.getText().toString());
                Call<LoginResult> call = retrofitInterface.executeLogin(map);
                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if(response.code()==200){
                            Toast.makeText(MainActivity.this, "Login effettuato", Toast.LENGTH_LONG).show();
                            p.setCognome(response.body().getCognome());
                            p.setNome(response.body().getNome());
                            p.setId(response.body().getId());
                            startActivity(new Intent(MainActivity.this, Schermata_Principale.class));

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
         return camera_permission == PackageManager.PERMISSION_GRANTED && vibrate_permission == PackageManager.PERMISSION_GRANTED &&
                  fine_permission == PackageManager.PERMISSION_GRANTED && coarse_permission == PackageManager.PERMISSION_GRANTED;

    }


    public void requestPermission() {
        int PERMISSION_REQUEST_CODE = 200;

        ActivityCompat.requestPermissions(this, new String[]{CAMERA,ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // this method is called when user
        // allows the permission to use camera.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            boolean cameraaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean fine_accepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean coarse_accepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            if (cameraaccepted && fine_accepted && coarse_accepted) {
                Toast.makeText(this, "Permission granted..", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denined \n You cannot use app without providing permission", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void next(View v){
        startActivity(new Intent(this, Schermata_Principale.class));
    }
}


