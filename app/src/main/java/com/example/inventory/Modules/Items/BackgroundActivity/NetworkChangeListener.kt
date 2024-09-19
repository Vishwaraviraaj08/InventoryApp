package com.example.inventory.Modules.BackgroundActivity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inventory.Modules.Items.AddItems.ItemData
import com.example.inventory.Modules.Items.AddItems.ItemDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class NetworkChangeListener(private val context: Context, private val service: NetworkMonitorService) {

    private val callback = object: ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            Toast.makeText(context, "Connected to the Internet", Toast.LENGTH_SHORT).show()

            val itemDao = ItemDatabase.createDatabase(context).itemDao()
            CoroutineScope(Dispatchers.IO).launch {
                val items = itemDao.getUnsyncedItems()
                println(items)
                if (items.isNotEmpty()) {
                    items.forEach { item ->
                        addItemsWhenConnectedToInternet(item)
                        itemDao.makeItemSynced(item.itemName)
                    }
                    itemDao.clearSyncedItems()
                }
                service.stopSelf()
            }
        }

        override fun onLost(network: Network) {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
        }
    }



    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun checkNetworkConnection() {
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(networkRequest, callback )
    }

    fun addItemsWhenConnectedToInternet(item: ItemData) {
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

        val queue = Volley.newRequestQueue(context)
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
                val accessToken = context.getSharedPreferences("user_info", Context.MODE_PRIVATE).getString("access_token", "")
                headers["Authorization"] = "Zoho-oauthtoken $accessToken"
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
        queue.add(request)
    }
}
