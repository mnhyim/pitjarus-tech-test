package com.mnhyim.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stores")
data class StoreEntity(

    @PrimaryKey
    val storeId: String,

    @ColumnInfo(name = "storeCode")
    val storeCode: String? = null,

    @ColumnInfo(name = "channelName")
    val channelName: String? = null,

    @ColumnInfo(name = "areaName")
    val areaName: String? = null,

    @ColumnInfo(name = "address")
    val address: String? = null,

    @ColumnInfo(name = "dcName")
    val dcName: String? = null,

    @ColumnInfo(name = "latitude")
    val latitude: String? = null,

    @ColumnInfo(name = "regionId")
    val regionId: String? = null,

    @ColumnInfo(name = "areaId")
    val areaId: String? = null,

    @ColumnInfo(name = "accountId")
    val accountId: String? = null,

    @ColumnInfo(name = "dcId")
    val dcId: String? = null,

    @ColumnInfo(name = "subchannelId")
    val subchannelId: String? = null,

    @ColumnInfo(name = "accountName")
    val accountName: String? = null,

    @ColumnInfo(name = "storeName")
    val storeName: String? = null,

    @ColumnInfo(name = "subchannelName")
    val subchannelName: String? = null,

    @ColumnInfo(name = "regionName")
    val regionName: String? = null,

    @ColumnInfo(name = "channelId")
    val channelId: String? = null,

    @ColumnInfo(name = "longitude")
    val longitude: String? = null
)