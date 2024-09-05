package com.example.inventory

import AdditionalInfo
import Item
import StockDetail
import StockInfo
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import readDataFromFile
import writeDataToFile

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addItemButton = findViewById<Button>(R.id.addItemButton)
        addItemButton.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val items = listOf(
            Item(
                id = "1",
                name = "Item One",
                sellingPrice = 50.0,
                costPrice = 30.0,
                quantity = 100.0,
                stockSummary = StockDetail(
                    physicalStock = StockInfo(100.0, 20.0, 80.0),
                    accountingStock = StockInfo(200.0, 30.0, 170.0)
                ),
                itemAccount = "Account1",
                openingStock = 50.0,
                reorderLevel = 10.0,
                additionalInfo = AdditionalInfo(
                    length = 10.0,
                    breadth = 5.0,
                    height = 2.0,
                    dimensionUnit = "cm",
                    weight = 1.5,
                    weightUnit = "kg",
                    mpn = "MPN12345",
                    isbn = "ISBN1234567890",
                    upc = "UPC1234567890"
                )
            ),
            Item(
                id = "2",
                name = "Item Two",
                sellingPrice = 60.0,
                costPrice = 40.0,
                quantity = 150.0,
                stockSummary = StockDetail(
                    physicalStock = StockInfo(200.0, 30.0, 170.0),
                    accountingStock = StockInfo(100.0, 20.0, 80.0)
                ),
                itemAccount = "Account2",
                openingStock = 75.0,
                reorderLevel = 15.0,
                additionalInfo = null // Item without additionalInfo
            )
        )


        writeDataToFile(this, items)

        val fetchedItems = readDataFromFile(this)


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = fetchedItems?.let { ItemAdapter(it) }

    }
}