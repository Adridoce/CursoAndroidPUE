package com.cursoandroid.explicitapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.explicitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras
        val mensaje = data?.getString("second_activity_et_text")

        binding.mainActivityTvText.text = mensaje ?: "Hello World"

        binding.mainActivityBtnSend.setOnClickListener { sendText() }
    }

    private fun sendText() {
        //Intent Explicito
        val intent = Intent(this, SecondActivity::class.java)
        val texto = binding.mainActivityEtText.text.toString()
        intent.putExtra("main_activity_et_text", texto)
        startActivity(intent)
    }
}