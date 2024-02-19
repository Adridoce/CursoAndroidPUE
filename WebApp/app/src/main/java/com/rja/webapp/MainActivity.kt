package com.rja.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rja.webapp.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleIntent()
    }

    private fun handleIntent() {

        val intent = this.intent
        val data = intent.data
        var url: URL? = null

        try {

            url = URL(data?.scheme, data?.host, data?.path)
            binding.mainActivityWeb1.loadUrl(url.toString())

        } catch (e: Exception) {
            e.printStackTrace()
        }



    }
}