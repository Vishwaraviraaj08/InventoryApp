import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

import android.content.SharedPreferences
import com.google.gson.Gson

fun writeDataToFile(context: Context, items: List<Item>) {
    val sharedPreferences = context.getSharedPreferences("items", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val gson = Gson()

    for (item in items) {
        val json = gson.toJson(item)
        editor.putString(item.name, json)
        editor.apply()
    }


}

fun readDataFromFile(context: Context): List<Item> {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("items", Context.MODE_PRIVATE)
    val gson = Gson()
    val items = mutableListOf<Item>()

    sharedPreferences.all.forEach { (key, value) ->
        val json = value as String
        val item = gson.fromJson(json, Item::class.java)
        items.add(item)
    }

    return items
}
