
import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inventory.Modules.Items.AddItems.DoubleDeserializer
import com.example.inventory.Modules.Items.AddItems.ItemData
import com.example.inventory.Modules.Items.ItemResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class ItemFunctions {
    companion object {

        fun fetchItems(context: Context, callback: (List<ItemData>) -> Unit) {
            val itemsList = mutableListOf<ItemData>()

            try {
                val url = "https://www.zohoapis.in/inventory/v1/items?organization_id=60031594227"

                val request = object : JsonObjectRequest(
                    Request.Method.GET, url, null, { response ->
                    val gson = GsonBuilder().registerTypeAdapter(Double::class.java, DoubleDeserializer()).create()
                    val items = gson.fromJson(response.toString(), ItemResponse::class.java).items
                    for (i in items) {
                        itemsList.add(i)
                    }
                    callback(itemsList)
                }, { error ->
                    println("error : $error")
                    error.printStackTrace()
                    callback(emptyList())
                }) {
                    override fun getHeaders(): MutableMap<String, String> {
                        val headers = HashMap<String, String>()
                        val accessToken = context.getSharedPreferences("user_info", Context.MODE_PRIVATE).getString("access_token", "")
                        headers["Authorization"] = "Zoho-oauthtoken $accessToken"
                        return headers
                    }
                }
                Volley.newRequestQueue(context).add(request)
            } catch (e: Exception) {
                println("Error : $e")
                callback(emptyList())
            }
        }
    }
}
