package com.mnhyim.data.repository

import com.mnhyim.data.source.local.database.AppDatabase
import com.mnhyim.data.source.local.entities.StoreEntity
import com.mnhyim.data.source.remote.UserApi
import com.mnhyim.domain.model.Store
import com.mnhyim.domain.repository.UserRepository
import com.mnhyim.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val api: UserApi,
    private val database: AppDatabase
) : UserRepository {

    override suspend fun userLogin(username: String, password: String): Resource<List<Store>> {
        val data = api.userLogin(username = username, password = password)
        /* TODO: should create mapper class later */
        val stores = data.stores?.map { store ->
            Store(
                storeId = store.storeId ?: "",
                storeCode = store.storeCode ?: "",
                channelName = store.channelName ?: "",
                areaName = store.areaName ?: "",
                address = store.address ?: "",
                dcName = store.dcName ?: "",
                latitude = store.latitude ?: "",
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
                longitude = store.longitude ?: "",
            )
        }

        return if (data.status == "success") {
            if (data.stores != null) {
                /* TODO: should create mapper class later */
                withContext(Dispatchers.IO) {
                    database.storeDao().insertAll(
                        data.stores.mapIndexed { index, store ->
                            StoreEntity(
                                storeId = "${store.storeId}-$index" ?: "",
                                storeCode = store.storeCode ?: "",
                                channelName = store.channelName ?: "",
                                areaName = store.areaName ?: "",
                                address = store.address ?: "",
                                dcName = store.dcName ?: "",
                                latitude = store.latitude ?: "",
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
                                longitude = store.longitude ?: "",
                            )
                        }
                    )
                }
            }

            Resource.Success(200, content = stores)
        } else {
            Resource.Error(code = 401, message = data.message)
        }
    }
}