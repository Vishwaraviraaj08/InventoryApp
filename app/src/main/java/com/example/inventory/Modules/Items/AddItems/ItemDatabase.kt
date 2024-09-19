package com.example.inventory.Modules.Items.AddItems

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ItemData::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {

        private var instance: ItemDatabase? = null

        const val DATABASE_NAME = "items"

        fun createDatabase(context: Context): ItemDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return instance as ItemDatabase
        }

    }
}
