package com.cursoandroid.notificationapp


import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var notificationManager: NotificationManager? = null
    private val NOTIFICATION_REQUEST_ID = 1001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(android.Manifest.permission.POST_NOTIFICATIONS, NOTIFICATION_REQUEST_ID)

        // Crear el notificationManager
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Crear el canal
        createNotificationChannel(
            id = "com.cursoandroid.notificationapp.news",
            name = "News",
            description = "News on 2024"
        )
    }

    private fun requestPermissions(permissionType: String, requestCode: Int) {
        val permission = ContextCompat.checkSelfPermission(
            this, permissionType
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(permissionType), requestCode
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            NOTIFICATION_REQUEST_ID -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,
                        "Permisos requeridos", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun createNotificationChannel(id: String, name: String, description: String) {

        // Importancia
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id, name, importance)

        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100, 200, 300)

        notificationManager?.createNotificationChannel(channel)
    }

    fun sendNotification(view: View) {

        val channelId = "com.cursoandroid.notificationapp.news"
        val notificationId = 1001

        val notification = Notification.Builder(this@MainActivity, channelId)
            .setContentTitle("Notificacion sesion Android")
            .setContentText("Info de la sesion de Android")
            .setSmallIcon(android.R.drawable.ic_dialog_info).setChannelId(channelId).build()

        notificationManager?.notify(notificationId, notification)
    }
}