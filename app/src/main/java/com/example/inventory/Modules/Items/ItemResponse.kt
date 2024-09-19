package com.example.inventory.Modules.Items

import com.example.inventory.Modules.Items.AddItems.ItemData

data class ItemResponse(
    val code: Int,
    val message: String,
    val items: List<ItemData>
)