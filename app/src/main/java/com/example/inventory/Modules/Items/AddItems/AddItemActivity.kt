package com.example.inventory.Modules.Items.AddItems

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inventory.Modules.BackgroundActivity.NetworkMonitorService
import com.example.inventory.Modules.Items.NetworkManager
import com.example.inventory.R
import com.example.inventory.databinding.ActivityAddItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddItemBinding
    private lateinit var database: ItemDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        println("AddItemActivity onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        database = ItemDatabase.createDatabase(this)
        setContentView(binding.root)


        val isConnectedToInternet = NetworkManager(this).isOnline()
        findViewById<TextView>(R.id.internetStatus).visibility = if (isConnectedToInternet) View.GONE else View.VISIBLE

        binding.checkBoxAdditionalInfo.setOnCheckedChangeListener { _, isChecked ->
            binding.additionalInfoSection.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        binding.checkBoxInventoryTrack.setOnCheckedChangeListener { _, isChecked ->
            binding.trackInventorySection.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        binding.buttonSave.setOnClickListener {
            gatherData()
        }








    }



    private fun gatherData() {

        val itemType = findViewById<RadioButton>(binding.itemType.checkedRadioButtonId).text.toString()
        val itemName = binding.itemName.text.toString()
        val itemSKU = binding.SKU.text.toString()
        val itemUnit = binding.itemUnit.selectedItem.toString()
        val itemReturnable = binding.checkBoxReturnableItem.isChecked


        val itemSp = binding.sellingPrice.text.toString().toDouble()
        val sellingAccount = binding.salesAccount.selectedItem.toString()

        val itemCp = binding.costPrice.text.toString().toDouble()
        val purchaseAccount = binding.purchaseAccount.selectedItem.toString()


        var openingStock = 0.0
        var openingStockValue = 0.0
        var reorderLevel = 0.0
        if (binding.checkBoxInventoryTrack.isChecked) {
            openingStock = binding.openingStock.text.toString().toDouble()
            openingStockValue = binding.openingStockRate.text.toString().toDouble()
            reorderLevel = binding.reorderLevel.text.toString().toDouble()
        }

        var length = 0.0
        var width = 0.0
        var height = 0.0
        var weight = 0.0
        var dimensionUnit = ""
        var weightUnit = ""
        var isbn = ""
        var upc = ""
        if (binding.checkBoxAdditionalInfo.isChecked){
            length = binding.editTextLength.text.toString().toDouble()
            width = binding.editTextWidth.text.toString().toDouble()
            height = binding.editTextHeight.text.toString().toDouble()
            weight = binding.editTextWeight.text.toString().toDouble()
            dimensionUnit = binding.spinnerDimensionUnit.selectedItem.toString()
            weightUnit = binding.spinnerWeightUnit.selectedItem.toString()
            isbn = binding.editTextISBN.text.toString()
            upc = binding.editTextUPC.text.toString()
        }



        val item = ItemData(
            itemType = itemType,
            itemName = itemName,
            itemSKU = itemSKU,
            itemUnit = itemUnit,
            itemReturnable = itemReturnable,

            itemSp = itemSp,
            sellingAccount = sellingAccount,
            itemCp = itemCp,
            purchaseAccount = purchaseAccount,

            openingStock = openingStock,
            openingStockValue = openingStockValue,
            reorderLevel = reorderLevel,

            length = length,
            width = width,
            height = height,
            weight = weight,
            dimensionUnit = dimensionUnit,
            weightUnit = weightUnit,
            isbn = isbn,
            upc = upc
        )

        if (NetworkManager(this).isOnline()) {
            ApiService(this).addItemToApi(item)
            finish()
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                database.itemDao().insert(item)
                val intent = Intent(this@AddItemActivity, NetworkMonitorService::class.java)
                startService(intent)
                finish()
            }
        }



    }

    override fun onStart() {
        super.onStart()
        enableEdgeToEdge()
    }

    override fun onPause() {
        super.onPause()
        println("AddItemActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        println("AddItemActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("AddItemActivity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        println("AddItemActivity onRestart")
    }

    override fun onResume() {
        super.onResume()
        println("AddItemActivity onResume")
    }


}