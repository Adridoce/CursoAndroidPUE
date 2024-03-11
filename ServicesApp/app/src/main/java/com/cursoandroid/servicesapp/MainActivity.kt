package com.cursoandroid.servicesapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var isBound = false
    var boundedService: BoundedService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculacion al servicio
        val intent = Intent(this, BoundedService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundedService.MyBinder
            boundedService = binder.getService()
            Log.i("MyService", "Service connected")
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.i("MyService", "Service disconnected")
            isBound = false
        }
    }

    fun showTime(view: View) {
        if (isBound) {
            val currentTime = boundedService?.getCurrentTime()
            Log.d("MyService", "Current time: $currentTime")
        }
    }

    fun initService(view: View) {
        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)
    }

    fun disconnectService(view: View) {
        if (isBound) {
            unbindService(serviceConnection)
            isBound = false
        }
    }
}