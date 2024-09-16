package com.example.inventory.Modules

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inventory.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.loginBtn).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.zoho.in/oauth/v2/auth?scope=ZohoInventory.invoices.CREATE,ZohoInventory.items.READ&client_id=1000.BZ2D2OQ4UQL9VAVXVCCLJF3YCTE25Z&state=testing&response_type=code&redirect_uri=https://tester-api.netlify.app/&access_type=offline"))
            startActivity(intent)
            finish()
        }

    }
}