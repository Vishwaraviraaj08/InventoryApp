package com.example.inventory.Modules.Items.AddItems

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class ApiService(context: Context) {

    private val context = context
    private val queue = Volley.newRequestQueue(context)
    val sharedPref = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
    private val database = ItemDatabase.createDatabase(context)

    fun addItemToApi(item: ItemData) {
        val url = "https://www.zohoapis.in/inventory/v1/items?organization_id=60031594227"
        val jsonBody = JSONObject().apply {
            put("product_type", item.itemType)
            put("name", item.itemName)
            put("sku", item.itemSKU)
            put("unit", item.itemUnit)
            put("is_returnable", item.itemReturnable)

            put("rate", item.itemSp)
            put("account_name", item.sellingAccount)
            put("purchase_rate", item.itemCp)
            put("purchase_account_name", item.purchaseAccount)

            put("stock_on_hand", item.openingStock)
            put("available_stock", item.openingStockValue)
            put("reorder_level", item.reorderLevel)

            put("length", item.length)
            put("width", item.width)
            put("height", item.height)
            put("weight", item.weight)
            put("dimension_unit", item.dimensionUnit)
            put("weight_unit", item.weightUnit)
            put("isbn", item.isbn)
            put("upc", item.upc)
        }

        Log.d("ApiService", "JSON Body: $jsonBody")

        val request = object: JsonObjectRequest(
            Request.Method.POST, url, jsonBody,
            { response ->
                Toast.makeText(context, "Item added successfully", Toast.LENGTH_SHORT).show()
            },
            { error ->
                println("Error in adding items : $error")
            }){
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                val accessToken = sharedPref.getString("access_token", "")
                headers["Authorization"] = "Zoho-oauthtoken $accessToken"
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
        queue.add(request)
    }



//    fun callApiForUnSyncedItems() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val items = database.itemDao().getUnsyncedItems()
//            fun addItemUsingApi(index: Int) {
//                if (index == items.size) {
//                    return
//                }
//                val item = items[index]
//                val url = "https://www.zohoapis.in/inventory/v1/items?organization_id=60031594227"
//                val jsonBody = JSONObject().apply {
//                    put("product_type", item.itemType)
//                    put("name", item.itemName)
//                    put("sku", item.itemSKU)
//                    put("unit", item.itemUnit)
//                    put("is_returnable", item.itemReturnable)
//
//                    put("rate", item.itemSp)
//                    put("account_name", item.sellingAccount)
//                    put("purchase_rate", item.itemCp)
//                    put("purchase_account_name", item.purchaseAccount)
//
//                    put("stock_on_hand", item.openingStock)
//                    put("available_stock", item.openingStockValue)
//                    put("reorder_level", item.reorderLevel)
//
//                    put("length", item.length)
//                    put("width", item.width)
//                    put("height", item.height)
//                    put("weight", item.weight)
//                    put("dimension_unit", item.dimensionUnit)
//                    put("weight_unit", item.weightUnit)
//                    put("isbn", item.isbn)
//                    put("upc", item.upc)
//                }
//
//                Log.d("ApiService", "JSON Body: $jsonBody")
//
//                val request = object: JsonObjectRequest(
//                    Request.Method.POST, url, jsonBody,
//                    { response ->
//                        addItemUsingApi(index + 1)
//                        item.isSynced = true
//                    },
//                    { error ->
//                        println("Error in adding items : $error")
//                        addItemUsingApi(index + 1)
//                    }){
//                    override fun getHeaders(): MutableMap<String, String> {
//                        val headers = HashMap<String, String>()
//                        val accessToken = sharedPref.getString("access_token", "")
//                        println("Access Token: $accessToken")
//                        headers["Authorization"] = "Zoho-oauthtoken $accessToken"
//                        headers["Content-Type"] = "application/json"
//                        return headers
//                    }
//                }
//                queue.add(request)
//            }
//            if (items.isNotEmpty())  addItemUsingApi(0)
//            ItemDatabase.createDatabase(context).itemDao().clearSyncedItems()
//
//        }
//
//    }
}
