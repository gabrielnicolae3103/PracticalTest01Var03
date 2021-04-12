package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class ProcessingThread  extends Thread{

    private Context context = null;
    private boolean isRunning = true;

    private double sum;
    private double difference;
    private int action = 0;
    private int sent = 0;

    public ProcessingThread(Context context, int firstNumber, int secondNumber) {
        this.context = context;

        sum = firstNumber + secondNumber;
        difference = firstNumber - secondNumber;
    }

    @Override
    public void run() {
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has stopped!");
    }

    private void sendMessage() {
        if (sent == 1) {
            stopThread();
        }
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[action]);
        if (action == 0) {
            intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                    new Date(System.currentTimeMillis()) + " " + sum );
            sent ++;
        } else {
            sent ++;
            intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                    new Date(System.currentTimeMillis()) + " " + difference);
        }

        context.sendBroadcast(intent);
        if (action == 0) action = 1;
        else if (action == 1) action = 0;
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
