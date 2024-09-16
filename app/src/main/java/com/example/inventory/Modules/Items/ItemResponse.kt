package com.example.inventory.Modules.Items

data class ItemResponse(
    val code: Int,
    val message: String,
    val items: List<Item>
)