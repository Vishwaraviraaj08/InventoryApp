package com.example.inventory.Modules

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inventory.R
import android.content.Intent
import android.net.Uri
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.inventory.Modules.Items.ViewItemsActivity

class ReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_receiver)

        val data: Uri? = intent.data
        val code = data?.getQueryParameter("code")
        if (code != null) {
            val queue = Volley.newRequestQueue(this@ReceiverActivity)
            val url = "https://accounts.zoho.in/oauth/v2/token?code=$code&client_id=1000.BZ2D2OQ4UQL9VAVXVCCLJF3YCTE25Z&client_secret=d68b2678aaf8351436a7584d44422f0f41c1d2f138&redirect_uri=https://tester-api.netlify.app/&grant_type=authorization_code"
            val request = JsonObjectRequest(
                Request.Method.POST, url, null,
                { response ->
                    val accessToken = response.getString("access_token")
                    val refreshToken = response.getString("refresh_token")
                    findViewById<TextView>(R.id.textView4).text = "Access Token: $accessToken\nRefresh Token: $refreshToken"
                    val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("access_token", accessToken)
                    editor.putString("refresh_token", refreshToken)
                    editor.putLong("token_saved_time", System.currentTimeMillis())
                    editor.apply()
                    val intent = Intent(this, ViewItemsActivity::class.java)
                    startActivity(intent)
                    finish()
                },
                { error ->
                    findViewById<TextView>(R.id.textView4).text = "Error: $error"
                }
            )
            queue.add(request)
        } else {
            findViewById<TextView>(R.id.textView4).text = "Authorization code not found."
        }


    }
}