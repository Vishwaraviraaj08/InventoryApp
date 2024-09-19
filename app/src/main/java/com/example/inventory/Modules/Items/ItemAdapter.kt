package com.example.inventory.Modules.Items

import com.example.inventory.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.Modules.Items.AddItems.ItemData

class ItemAdapter (private val items: List<ItemData>) : RecyclerView.Adapter<ItemAdapter.CustomViewHolder>() {

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.item_name)
        val itemDetails: TextView = view.findViewById(R.id.item_details)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text = item.itemName
        holder.itemDetails.text = item.itemSp.toString()
    }

}
