package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PracticalTest01Var03Service extends Service {

    ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String firstNumber = intent.getStringExtra(Constants.NUMBER_1);
        String secondNumber = intent.getStringExtra(Constants.NUMBER_2);
        processingThread = new ProcessingThread(this, Integer.valueOf(firstNumber), Integer.valueOf(secondNumber));
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}
