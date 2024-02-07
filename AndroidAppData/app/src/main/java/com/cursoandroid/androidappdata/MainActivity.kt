package com.cursoandroid.androidappdata

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.androidappdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainActivityBtnAccept.setOnClickListener {
            updateMessage()
        }

        if (savedInstanceState != null) {
            binding.mainActivityTvMessage.text = savedInstanceState.getString("message")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("message", binding.mainActivityTvMessage.text.toString())
    }

    private fun updateMessage() {
        val userName = binding.mainActivityEtText.text
        val messages = listOf("Mantente en forma", "Buenos dias", "Feliz tarde", "Happy Coding")
        val index = (0..3).random()
        val activeMessage = messages[index]

        if (userName.toString() == "") {
            binding.mainActivityTvMessage.text = getString(R.string.activity_main_make_sure)
        } else {
            binding.mainActivityTvMessage.text = "Hola $userName\n Frase del dia: $activeMessage"
        }

        binding.mainActivityEtText.setText("")

        hideKeyboard()
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.mainActivityEtText.windowToken, 0)
    }
}