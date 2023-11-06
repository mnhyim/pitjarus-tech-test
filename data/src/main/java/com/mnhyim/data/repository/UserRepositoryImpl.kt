package com.mnhyim.data.repository

import com.mnhyim.data.source.UserApi
import com.mnhyim.domain.model.Store
import com.mnhyim.domain.repository.UserRepository

class UserRepositoryImpl(
    private val api: UserApi
) : UserRepository {

    override suspend fun userLogin(username: String, password: String): List<Store> {
        api.userLogin(username = username, password = password)
//        Timber.d("userLogin - Called")
//        val data = api.userLogin(
//            LoginRequest(username, password)
//        ).stores
//        Timber.d("data: $data")
//        /* TODO: Temporary impl */
//        if (data != null) {
//            Timber.d("data: null")
//            return data.let { stores ->
//                stores.map { store ->
//                    Store(
//                        storeId = store.storeId ?: "",
//                        storeCode = store.storeCode ?: "",
//                        channelName = store.channelName ?: "",
//                        areaName = store.areaName ?: "",
//                        address = store.address ?: "",
//                        dcName = store.dcName ?: "",
//                        latitude = store.latitude ?: "",
//                        regionId = store.regionId ?: "",
//                        areaId = store.areaId ?: "",
//                        accountId = store.accountId ?: "",
//                        dcId = store.dcId ?: "",
//                        subchannelId = store.subchannelId ?: "",
//                        accountName = store.accountName ?: "",
//                        storeName = store.storeName ?: "",
//                        subchannelName = store.subchannelName ?: "",
//                        regionName = store.regionName ?: "",
//                        channelId = store.channelId ?: "",
//                        longitude = store.longitude ?: "",
//                    )
//                }
//            }
//        } else {
//            Timber.d("data: empty")
        return emptyList()
//        }
    }
}