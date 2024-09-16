package com.example.inventory

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.textViewsample).apply {
            val accessToken = intent.getStringExtra("access_token")
            val refreshToken = intent.getStringExtra("refresh_token")
            this.text = "Access Token: $accessToken\nRefresh Token: $refreshToken"
        }

    }
}