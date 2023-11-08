package com.mnhyim.data.repository

import com.mnhyim.data.source.local.database.AppDatabase
import com.mnhyim.domain.model.Store
import com.mnhyim.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreRepositoryImpl(
    private val database: AppDatabase
) : StoreRepository {
    override fun getStoreById(id: String): Flow<Store> {
        return database.storeDao().getStoreById(id).map { store ->
            Store(
                storeId = store.storeId,
                storeCode = store.storeCode ?: "",
                channelName = store.channelName ?: "",
                areaName = store.areaName ?: "",
                address = store.address ?: "",
                dcName = store.dcName ?: "",
                regionId = store.regionId ?: "",
                areaId = store.areaId ?: "",
                accountId = store.accountId ?: "",
                dcId = store.dcId ?: "",
                subchannelId = store.subchannelId ?: "",
                accountName = store.accountName ?: "",
                storeName = store.storeName ?: "",
                subchannelName = store.subchannelName ?: "",
                regionName = store.regionName ?: "",
                channelId = store.channelId ?: "",
                latitude = store.latitude?.toDouble() ?: 0.0,
                longitude = store.longitude?.toDouble() ?: 0.0,
            )
        }
    }

    override fun getAllStore(): Flow<List<Store>> {
        return database.storeDao().getAll().map { stores ->
            stores.mapIndexed { index, store ->
                Store(
                    storeId = store.storeId,
                    storeCode = store.storeCode ?: "",
                    channelName = store.channelName ?: "",
                    areaName = store.areaName ?: "",
                    address = store.address ?: "",
                    dcName = store.dcName ?: "",
                    regionId = store.regionId ?: "",
                    areaId = store.areaId ?: "",
                    accountId = store.accountId ?: "",
                    dcId = store.dcId ?: "",
                    subchannelId = store.subchannelId ?: "",
                    accountName = store.accountName ?: "",
                    storeName = store.storeName ?: "",
                    subchannelName = store.subchannelName ?: "",
                    regionName = store.regionName ?: "",
                    channelId = store.channelId ?: "",
                    latitude = ((store.latitude?.toDouble() ?: 0.0) + (index*2)),
                    longitude = ((store.longitude?.toDouble() ?: 0.0) + (index * 2)),
                )
            }
        }
    }

    override fun cleanStoreList() {
        TODO("Not yet implemented")
    }

}