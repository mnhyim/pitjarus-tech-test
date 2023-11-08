package com.mnhyim.domain.repository

import com.mnhyim.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    fun getStoreById(id: String): Flow<Store>
    fun getAllStore(): Flow<List<Store>>
    fun cleanStoreList()
}