package com.cursoandroid.permisosapp

import android.Manifest.permission.RECORD_AUDIO
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "PermisosApp"
    private val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPermissions()
    }

    private fun setupPermissions() {

        val permissionAudio = ContextCompat.checkSelfPermission(this, RECORD_AUDIO)

        if (permissionAudio != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permision to record")
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, RECORD_AUDIO)) {
                // Crear un dialogo con patron builder
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Le recuerdo que el permiso de audio es necesario para ...")
                    .setTitle("Permiso requerido")
                    .setPositiveButton("Ok") { dialog, id ->
                        makeRequest()
                    }

                val dialog = builder.create()
                dialog.show()

            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(RECORD_AUDIO), REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "El permiso ha sido denegado por el usuario")
                }
                else {
                    Log.i(TAG, "El permiso ha sido permitido por el usuario")
                }
            }
        }

    }

}