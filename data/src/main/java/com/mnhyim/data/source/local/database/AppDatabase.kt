package com.mnhyim.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.data.source.local.dao.StoreDao
import com.mnhyim.data.source.local.entities.StoreEntity

@Database(entities = [StoreEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun storeDao(): StoreDao
}