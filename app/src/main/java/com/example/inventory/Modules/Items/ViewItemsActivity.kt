package com.example.inventory.Modules.Items

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkRequest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.Modules.Items.AddItems.AddItemActivity
import com.example.inventory.Modules.Items.AddItems.ApiService
import com.example.inventory.Modules.UtilityFunctions
import com.example.inventory.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.concurrent.TimeUnit


class ViewItemsActivity : AppCompatActivity() {

    private lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        println("ViewItemsActivity onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_items)

        networkMonitor = NetworkMonitor(this)
        networkMonitor.observe(this) { isConnected ->
            if (isConnected) {
                findViewById<TextView>(R.id.netStatus).visibility = View.GONE
            } else {
                findViewById<TextView>(R.id.netStatus).visibility = View.VISIBLE
            }
        }
    }



    override fun onResume() {
        println("ViewItemsActivity onResume")
        super.onResume()
        val sharedPrefs = getSharedPreferences("user_info", MODE_PRIVATE)
        val tokenSavedTime = sharedPrefs.getLong("token_saved_time", 0L)
        val currentTime = System.currentTimeMillis()

        findViewById<FloatingActionButton>(R.id.fabAddItem).setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }

        findViewById<FloatingActionButton>(R.id.refreshBtn).setOnClickListener {
            findViewById<RecyclerView>(R.id.recycler_view).adapter = null
            fetchAndDisplayItems()
        }



        if (currentTime - tokenSavedTime > TimeUnit.HOURS.toMillis(1)) {
            UtilityFunctions.getAccessTokenFromRefreshToken(this) { token ->
                sharedPrefs.edit().putString("access_token", token)
                    .putLong("token_saved_time", System.currentTimeMillis())
                    .apply()
                fetchAndDisplayItems()
            }
        } else{
            fetchAndDisplayItems()
        }
    }

    private fun fetchAndDisplayItems() {
        ItemFunctions.fetchItems(this) { items ->
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ItemAdapter(items)
        }
    }


    override fun onStart() {
        super.onStart()
        println("ViewItemsActivity onStart")
    }

    override fun onPause() {
        super.onPause()
        println("ViewItemsActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        println("ViewItemsActivity onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        println("ViewItemsActivity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        println("ViewItemsActivity onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("ViewItemsActivity onSaveInstanceState")
    }


    
}


