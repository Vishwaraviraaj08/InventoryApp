package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.inventory.Modules.Items.ViewItemsActivity
import com.example.inventory.Modules.LoginActivity

class AppLoading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_loading)

        supportActionBar?.hide()

        val logoIcon = findViewById<ImageView>(R.id.imageView)
        val logoText = findViewById<TextView>(R.id.textView2)

        logoText.animation = AnimationUtils.loadAnimation(this, R.anim.logo_text)
        logoIcon.animation = AnimationUtils.loadAnimation(this, R.anim.logo_icon)


        Handler().postDelayed({
//            startActivity(Intent(this, LoginActivity::class.java))
            if (getSharedPreferences("user_info", MODE_PRIVATE).getString("refresh_token", null) != null) {
                startActivity(Intent(this, ViewItemsActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }, 2500)

    }
}