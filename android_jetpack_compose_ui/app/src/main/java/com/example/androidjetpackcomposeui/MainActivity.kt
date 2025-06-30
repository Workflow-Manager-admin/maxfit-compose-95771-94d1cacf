package com.example.androidjetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidjetpackcomposeui.ui.theme.MaxFitTheme

// PUBLIC_INTERFACE
class MainActivity : ComponentActivity() {
    /** Main entry point for the MaxFit Compose Fitness App. Handles Compose setup and navigation. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaxFitTheme {
                // Set up navigation, display WelcomeScreen by default
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MaxFitNavHost()
                }
            }
        }
    }
}
