package com.example.inventory.Modules.Items.AddItems

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ItemData)

    @Query("SELECT * FROM items WHERE isSynced = 0")
    suspend fun getUnsyncedItems(): List<ItemData>

    @Query("DELETE FROM items")
    suspend fun clearSyncedItems()

    @Query("UPDATE items SET isSynced = 1 WHERE itemName = :name")
    suspend fun makeItemSynced(name: String)


}

