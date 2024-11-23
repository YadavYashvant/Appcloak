package com.yashvant.appcloak.ui.screens


import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppScreen() {
    var websiteUrl by remember { mutableStateOf("") }
    var appName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Enter Website URL", style = MaterialTheme.typography.headlineMedium)
        BasicTextField(
            value = websiteUrl,
            onValueChange = { websiteUrl = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Enter App Name", style = MaterialTheme.typography.h6)
        BasicTextField(
            value = appName,
            onValueChange = { appName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (websiteUrl.isNotBlank() && appName.isNotBlank()) {
                    // Start WebViewActivity
                    val intent = Intent().apply {
                        setClassName(
                            "com.example.dynamicwebviewapp",
                            "com.example.dynamicwebviewapp.WebViewActivity"
                        )
                        putExtra("URL", websiteUrl)
                        putExtra("APP_NAME", appName)
                    }
                    it.context.startActivity(intent)
                } else {
                    Toast.makeText(it.context, "Fields cannot be empty!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Generate App")
        }
    }
}
