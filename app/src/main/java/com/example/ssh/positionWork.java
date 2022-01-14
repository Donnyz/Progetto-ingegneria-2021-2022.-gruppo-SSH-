package com.example.ssh;

import static com.example.ssh.Documento_o_Mappa_scelta_genitori.creaNotifica;
import static com.example.ssh.MainActivity.Notf_channel.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.ForegroundInfo;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class positionWork extends Worker {


    private final int Notification_id = 10;

    public positionWork(Context t, WorkerParameters p) {
        super(t, p);
    }



    @Override
    public Result doWork() {
        //prova lavoro.
        setForegroundAsync(createForgroudnIfo("prova"));
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("thread di conteggio", "thread" + i);
        }
        return Result.success();
    }


    @Override
    public void onStopped() {
        super.onStopped();
    }

    private ForegroundInfo createForgroudnIfo(String Message){
        Intent n = new Intent();
        PendingIntent pResult = PendingIntent.getActivity(this.getApplicationContext(),1,n,PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder Builder = new NotificationCompat.Builder(this.getApplicationContext(),CHANNEL_ID);
        Builder.setContentTitle("Posizione").
                setContentText(Message).
                setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true).
                setContentIntent(pResult);
        return new ForegroundInfo(Notification_id,Builder.build());
    }


}

