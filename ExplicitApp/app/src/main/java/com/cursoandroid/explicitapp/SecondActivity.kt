package com.cursoandroid.explicitapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.explicitapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras ?: return
        val mensaje = data.getString("main_activity_et_text")

        binding.secondActivityTvText.text = mensaje

        binding.secondActivityBtnSend.setOnClickListener { returnText() }
    }

    fun returnText() {
        // Intent explicito
        val intent = Intent(this, MainActivity::class.java)
        val texto = binding.secondActivityEtText.text.toString()
        intent.putExtra("second_activity_et_text", texto)
        startActivity(intent)
    }
}
