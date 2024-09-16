package com.example.inventory.Modules.Items

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.inventory.R
import java.io.IOException


class ViewItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_items)

        val btnClick = findViewById<Button>(R.id.btnClick)

        btnClick.setOnClickListener {
            fetchAndDisplayItems()
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
