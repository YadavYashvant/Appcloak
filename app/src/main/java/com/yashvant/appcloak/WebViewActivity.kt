package com.yashvant.appcloak

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity

class WebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        webView.webViewClient = WebViewClient()
        val url = intent.getStringExtra("URL")
        webView.loadUrl(url ?: "https://www.example.com")
        setContentView(webView)
    }
}