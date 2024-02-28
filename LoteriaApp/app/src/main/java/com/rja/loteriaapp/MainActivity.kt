package com.rja.loteriaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rja.loteriaapp.ui.theme.LoteriaAppTheme
import com.rja.loteriaapp.viewModels.ContadorViewModel
import com.rja.loteriaapp.viewModels.LoteriaViewModel
import com.rja.loteriaapp.views.Contador
import com.rja.loteriaapp.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val viewModel: ContadorViewModel by viewModels()
        val viewModel: LoteriaViewModel by viewModels()

        setContent {
            LoteriaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //Contador(viewModel = viewModel)
                    LoteriaView(viewModel = viewModel)
                }
            }
        }
    }
}

