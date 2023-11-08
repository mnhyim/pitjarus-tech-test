package com.mnhyim.domain.repository

import com.mnhyim.domain.model.Store
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    fun getStoreList(): Flow<List<Store>>
    fun cleanStoreList()
}