package com.mnhyim.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mnhyim.data.source.local.entities.StoreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreDao {

    @Query("SELECT * FROM stores")
    fun getAll(): Flow<List<StoreEntity>>

    @Insert
    fun insert(store: StoreEntity)

    @Insert
    fun insertAll(stores: List<StoreEntity>)

    @Delete
    fun delete(news: StoreEntity)
}