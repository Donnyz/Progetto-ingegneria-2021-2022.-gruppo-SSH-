 package com.example.ssh;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;



 public class Qr_Reader extends AppCompatActivity {
     private ScannerLiveView camera;
     public  static final String EXTRA_TEXT= "com.example.ssh.";



     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_qr_reader);


         // initialize scannerLiveview and textview.
         camera = (ScannerLiveView) findViewById(R.id.camview);

         camera.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
             @Override
             public void onScannerStarted(ScannerLiveView scanner) {
                 // method is called when scanner is started
                 Toast.makeText(Qr_Reader.this, "Scanner Started", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onScannerStopped(ScannerLiveView scanner) {
                 // method is called when scanner is stopped.
                 Toast.makeText(Qr_Reader.this, "Scanner Stopped", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onScannerError(Throwable err) {
                 // method is called when scanner gives some error.
                 Toast.makeText(Qr_Reader.this, "Scanner Error: " + err.getMessage(), Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onCodeScanned(String data) {
                 Show_result(data);

             }

         });
     }

     private void Show_result(String data) {
         Intent i = new Intent(this, Qr_result.class);
         i.putExtra(EXTRA_TEXT,data);
         startActivity(i);
     }

     @Override
     protected void onResume() {
         super.onResume();
         ZXDecoder decoder = new ZXDecoder();
         // 0.5 is the area where we have
         // to place red marker for scanning.
         decoder.setScanAreaPercent(0.8);
         // below method will set secoder to camera.
         camera.setDecoder(decoder);
         camera.startScanner();
     }

     @Override
     protected void onPause() {
         // on app pause the
         // camera will stop scanning.
         camera.stopScanner();
         super.onPause();
     }
 }
