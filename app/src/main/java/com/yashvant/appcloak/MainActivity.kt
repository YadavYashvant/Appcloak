package com.yashvant.appcloak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yashvant.appcloak.ui.screens.AppScreen
import com.yashvant.appcloak.ui.theme.AppcloakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppcloakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
               AppScreen(modifier = Modifier.padding(innerPadding), this) }
            }
        }
    }
}
