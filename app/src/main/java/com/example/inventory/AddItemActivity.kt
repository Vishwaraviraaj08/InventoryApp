package com.example.inventory

import AdditionalInfo
import Item
import StockDetail
import StockInfo
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import writeDataToFile

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_item)

        val spinnerAccountType: Spinner = findViewById(R.id.spinnerSalesAccount)
        val spinnerPurchaseAccount: Spinner = findViewById(R.id.spinnerPurchaseAccount)
        val checkBoxInventoryTrack: CheckBox = findViewById(R.id.checkBoxInventoryTrack)
        val linearLayoutInventory: LinearLayout = findViewById(R.id.trackInventorylayout)
        val checkBoxAdditionalInfo: CheckBox = findViewById(R.id.checkBoxAdditionalInfo)
        val linearLayoutAdditionalInfo: LinearLayout = findViewById(R.id.linearLayoutAdditionalInfo)

        checkBoxInventoryTrack.setOnCheckedChangeListener { _ , isChecked ->
            println()
            linearLayoutInventory.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        checkBoxAdditionalInfo.setOnCheckedChangeListener { _, isChecked ->
            linearLayoutAdditionalInfo.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        val accountTypeAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.account_types,
            R.layout.spinner_item
        )
        spinnerAccountType.adapter = accountTypeAdapter

        val purchaseAccountAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.account_types,
            R.layout.spinner_item
        )
        spinnerPurchaseAccount.adapter = purchaseAccountAdapter

        val dimensionUnitAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.dimension_units,
            R.layout.spinner_item
        )
        findViewById<Spinner>(R.id.spinnerDimensionUnit).adapter = dimensionUnitAdapter

        val weightUnitAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.weight_units,
            R.layout.spinner_item
        )
        findViewById<Spinner>(R.id.spinnerWeightUnit).adapter = weightUnitAdapter

        findViewById<Button>(R.id.buttonSave).setOnClickListener {
            gatherData()
        }
    }

    private fun gatherData() {
        val itemName = findViewById<EditText>(R.id.editTextItemName).text.toString()
        val sku = findViewById<EditText>(R.id.editTextSKU).text.toString()
        val noOfUnits = findViewById<EditText>(R.id.editTextNoOfUnits).text.toString().toDoubleOrNull() ?: 0.0
        val sellingPrice = findViewById<EditText>(R.id.editTextSellingPrice).text.toString().toDoubleOrNull() ?: 0.0
        val itemAccount = findViewById<Spinner>(R.id.spinnerSalesAccount).selectedItem.toString()
        val costPrice = findViewById<EditText>(R.id.editTextCostPrice).text.toString().toDoubleOrNull() ?: 0.0
        val trackInventory = findViewById<CheckBox>(R.id.checkBoxInventoryTrack).isChecked

        val stockSummary = if (trackInventory) {
            val openingStock = findViewById<EditText>(R.id.editTextOpeningStock).text.toString().toDoubleOrNull() ?: 0.0
            val openingStockRate = findViewById<EditText>(R.id.editTextOpeningStockRate).text.toString().toDoubleOrNull() ?: 0.0
            val reorderLevel = findViewById<EditText>(R.id.editTextReorderLevel).text.toString().toDoubleOrNull() ?: 0.0

            // Example values for StockInfo
            val physicalStock = StockInfo(openingStock, openingStockRate, openingStock - reorderLevel)
            val accountingStock = StockInfo(openingStock, openingStockRate, openingStock - reorderLevel)
            StockDetail(physicalStock, accountingStock)
        } else {
            StockDetail(
                physicalStock = StockInfo(0.0, 0.0, 0.0),
                accountingStock = StockInfo(0.0, 0.0, 0.0)
            )
        }

        val additionalInfo = if (findViewById<CheckBox>(R.id.checkBoxAdditionalInfo).isChecked) {
            AdditionalInfo(
                length = findViewById<EditText>(R.id.editTextLength).text.toString().toDouble(),
                breadth = findViewById<EditText>(R.id.editTextBreadth).text.toString().toDouble(),
                height = findViewById<EditText>(R.id.editTextHeight).text.toString().toDouble(),
                dimensionUnit = findViewById<Spinner>(R.id.spinnerDimensionUnit).selectedItem.toString(),
                weight = findViewById<EditText>(R.id.editTextWeight).text.toString().toDouble(),
                weightUnit = findViewById<Spinner>(R.id.spinnerWeightUnit).selectedItem.toString(),
                mpn = findViewById<EditText>(R.id.editTextMPN).text.toString(),
                isbn = findViewById<EditText>(R.id.editTextISBN).text.toString(),
                upc = findViewById<EditText>(R.id.editTextUPC).text.toString()
            )
        } else null

        val item = Item(
            id = "PROD-${System.currentTimeMillis()}" + sku,
            name = itemName,
            sellingPrice = sellingPrice,
            costPrice = costPrice,
            quantity = noOfUnits,
            stockSummary = stockSummary,
            itemAccount = itemAccount,
            openingStock = if (trackInventory) findViewById<EditText>(R.id.editTextOpeningStock).text.toString().toDoubleOrNull() ?: 0.0 else 0.0,
            reorderLevel = if (trackInventory) findViewById<EditText>(R.id.editTextReorderLevel).text.toString().toDoubleOrNull() ?: 0.0 else 0.0,
            additionalInfo = additionalInfo
        )

        writeDataToFile(this, listOf(item))

        Toast.makeText(this, "Item saved successfully", Toast.LENGTH_SHORT).show()

        finish()
    }
}
