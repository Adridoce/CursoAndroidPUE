package com.cursoandroid.servicesapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BoundedService : Service() {

    private val myBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
            Locale.US)
        return dateformat.format(Date())
    }

    inner class MyBinder : Binder() {
        fun getService(): BoundedService {
            return this@BoundedService
        }
    }
}