package com.cursoandroid.helloandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.helloandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun convertCurrency(view: View) {
        if (binding.tvCurrency.text.isNotEmpty()) {
            val dollarValue = binding.etDollar.text.toString().toFloat()
            val euroValue = dollarValue * 0.85f
            binding.tvCurrency.text = euroValue.toString()
        }
        else {
            binding.tvCurrency.text = getString(R.string.activity_main_no_data)
        }
    }
}