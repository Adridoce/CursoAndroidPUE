package com.rja.rebajasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rja.rebajasapp.ui.theme.RebajasAppTheme
import com.rja.rebajasapp.viewModels.CalcularViewModelV3
import com.rja.rebajasapp.views.HomeViewV3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CalcularViewModelV3 by viewModels()

        setContent {
            RebajasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeViewV3(paddingValues = PaddingValues(15.dp), viewModel = viewModel)
                }
            }
        }
    }
}

