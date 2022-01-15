package com.example.ssh;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ssh.databinding.ActivityMappaGenitoreBinding;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mappa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMappaGenitoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMappaGenitoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        checkPermission();
        mMap.setMyLocationEnabled(true);

        HashMap<String, String> map = new HashMap<>();
        map.put("id",MainActivity.getP().getId());
        Call<ArrayList<Posizione>> call = MainActivity.retrofitInterface.executeOttieniPosizione(map);
        call.enqueue(new Callback<ArrayList<Posizione>>() {
            @Override
            public void onResponse(Call<ArrayList<Posizione>> call, Response<ArrayList<Posizione>> response) {
                for (Posizione x : response.body())
                    mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(x.getLatitudine()),Double.parseDouble(x.getLongitudine()))).title(x.getBambino()));
            }

            @Override
            public void onFailure(Call<ArrayList<Posizione>> call, Throwable t) {
                Toast.makeText(Mappa.this,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }





    public boolean checkPermission() {
        int fine_permission = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int coarse_permission = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);
        return fine_permission == PackageManager.PERMISSION_GRANTED && coarse_permission == PackageManager.PERMISSION_GRANTED;

    }


}