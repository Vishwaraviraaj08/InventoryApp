package com.example.inventory.Modules

import android.content.Context
import android.content.Intent
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class UtilityFunctions {
    companion object {

        fun getAccessTokenFromRefreshToken(context: Context, callback: (String) -> Unit) {
            val refreshToken = context.getSharedPreferences("user_info", Context.MODE_PRIVATE).getString("refresh_token", null)
            if (refreshToken == null) {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
            else {
                val url = "https://accounts.zoho.in/oauth/v2/token?refresh_token=$refreshToken&client_id=1000.BZ2D2OQ4UQL9VAVXVCCLJF3YCTE25Z&client_secret=d68b2678aaf8351436a7584d44422f0f41c1d2f138&redirect_uri=https://tester-api.netlify.app/&grant_type=refresh_token"
                val req = JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    null,
                    { response ->
                        val accessToken = response.getString("access_token")
                        val sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.putString("access_token", accessToken)
                        editor.apply()
                    },
                    { error ->
                        error.printStackTrace()
                    }
                )
                Volley.newRequestQueue(context).add(req)
            }
        }


    }
}