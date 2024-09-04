package com.example.testapplication

// FileUtils.kt
import Item
import android.content.Context
import com.google.gson.Gson
import java.io.File

import com.google.gson.JsonParser

fun readDataFromFile(context: Context): List<Item>? {
    val file = File(context.filesDir, "items.json")
    if (!file.exists()) return null

    val jsonString = file.readText()
    val gson = Gson()
    val jsonArray = JsonParser.parseString(jsonString).asJsonArray
    return jsonArray.mapNotNull { jsonElement ->
        try {
            gson.fromJson(jsonElement, Item::class.java)
        } catch (e: Exception) {
            null
        }
    }
}

fun writeDataToFile(context: Context, items: List<Item>) {
    val gson = Gson()
    val jsonString = gson.toJson(items)
    val file = File(context.filesDir, "items.json")
    file.writeText(jsonString)
}


