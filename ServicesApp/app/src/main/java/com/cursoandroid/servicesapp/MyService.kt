package com.cursoandroid.servicesapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val TAG = "MyService"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        coroutineScope.launch {
            doSomething(startId)
        }

        return START_STICKY
    }

    private suspend fun doSomething(startId: Int) {

        Log.i(TAG, "Service onStartCommand " + startId)

        var i: Int = 0

        while (i <= 3) {
            try {
                delay(5_000)
                i++
            } catch (e: Exception) {
            }
            Log.i(TAG, "Service running " + startId)
        }
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Service destroying... ")
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

}