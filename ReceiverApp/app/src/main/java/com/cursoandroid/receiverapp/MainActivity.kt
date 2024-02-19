package com.cursoandroid.receiverapp

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureReceiver()
    }

    private fun configureReceiver() {
        // Crear un intent filter
        val filter = IntentFilter()

        // Actions
        filter.addAction("com.cursoandroid.receiverapp.MY_ACTION")
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    fun broadcastIntent(view: View) {

        val intent = Intent()

        intent.action = "com.cursoandroid.receiverapp.MY_ACTION"
        intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)
    }
}