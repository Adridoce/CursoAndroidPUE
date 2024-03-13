package com.cursoandroid.mapsapp

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
import com.cursoandroid.mapsapp.navigation.NavManager
import com.cursoandroid.mapsapp.ui.theme.MapsAppTheme
import com.cursoandroid.mapsapp.viewmodel.SearchViewModel
import com.cursoandroid.mapsapp.views.MapsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: SearchViewModel by viewModels()

        setContent {
            MapsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MapsView()
                    NavManager(viewModel)
                }
            }
        }
    }
}

