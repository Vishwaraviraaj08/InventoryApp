package com.example.inventory.Modules.Items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.Modules.UtilityFunctions
import com.example.inventory.R
import java.util.concurrent.TimeUnit


class ViewItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_items)

        val sharedPrefs = getSharedPreferences("user_info", MODE_PRIVATE)
        val savedToken = sharedPrefs.getString("access_token", null)
        val tokenSavedTime = sharedPrefs.getLong("token_saved_time", 0L)
        val currentTime = System.currentTimeMillis()

        if (savedToken != null && currentTime - tokenSavedTime > TimeUnit.HOURS.toMillis(1)) {
            UtilityFunctions.getAccessTokenFromRefreshToken(this) { accessToken ->
                sharedPrefs.edit().putString("access_token", accessToken)
                    .putLong("token_saved_time", System.currentTimeMillis())
                    .apply()
            }
        }


        fetchAndDisplayItems()
    }


    private fun fetchAndDisplayItems() {
        ItemFunctions.fetchItems(this) { items ->
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this)

            if (items.isNotEmpty()) {
                recyclerView.adapter = ItemAdapter(items)
            } else {
                println("No items fetched")
            }
        }


    }
    
}
