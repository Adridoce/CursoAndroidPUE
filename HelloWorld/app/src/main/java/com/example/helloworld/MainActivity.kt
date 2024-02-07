package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.databinding.ActivityMainBinding

//MainActivity extends from AppCompatActivity giving it more functionality.
class MainActivity : AppCompatActivity() {
    //onCreate is a lifecycle method that runs only once at the start of the app.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargar en memoria el layout (xml)
        // setContentView(R.layout.activity_main)

        // Enlace de vistas (ViewBinding)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaludar.setOnClickListener {
            val nombre = binding.etNombre.text
            Toast.makeText(this, "Hola $nombre!", Toast.LENGTH_LONG).show()
        }

        //Log.i("Adri", "onCreate")
    }

/*    Override all lifecycle methods to learn about them!
    override fun onStart() {
        super.onStart()
        Log.i("Adri", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Adri", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Adri", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Adri", "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Adri", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Adri", "onDestroy")
    } */
}