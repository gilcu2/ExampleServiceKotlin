package com.gilcu2.exampleservice1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class HelloService : Service() {

    private var isRunning = false

    override fun onCreate() {
        Log.i(TAG, "Service onCreate")

        isRunning = true
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        Log.i(TAG, "Service onStartCommand")

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
        Thread(Runnable {
            //Your logic that service will perform will be placed here
            //In this example we are just looping and waits for 1000 milliseconds in each loop.
            for (i in 0..4) {
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {
                }

                if (isRunning) {
                    Log.i(TAG, "Service running")
                }
            }

            //Stop service once it finishes its task
            stopSelf()
        }).start()

        return Service.START_STICKY
    }


    override fun onBind(arg0: Intent): IBinder? {
        Log.i(TAG, "Service onBind")
        return null
    }

    override fun onDestroy() {

        isRunning = false

        Log.i(TAG, "Service onDestroy")
    }

    companion object {

        private val TAG = "HelloService"
    }
}