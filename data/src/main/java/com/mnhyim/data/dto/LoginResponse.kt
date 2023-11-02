package com.mnhyim.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(

	@Json(name="stores")
	val stores: List<StoresItem?>? = null,

	@Json(name="message")
	val message: String? = null,

	@Json(name="status")
	val status: String? = null
)

data class StoresItem(

	@Json(name="store_id")
	val storeId: String? = null,

	@Json(name="store_code")
	val storeCode: String? = null,

	@Json(name="channel_name")
	val channelName: String? = null,

	@Json(name="area_name")
	val areaName: String? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="dc_name")
	val dcName: String? = null,

	@Json(name="latitude")
	val latitude: String? = null,

	@Json(name="region_id")
	val regionId: String? = null,

	@Json(name="area_id")
	val areaId: String? = null,

	@Json(name="account_id")
	val accountId: String? = null,

	@Json(name="dc_id")
	val dcId: String? = null,

	@Json(name="subchannel_id")
	val subchannelId: String? = null,

	@Json(name="account_name")
	val accountName: String? = null,

	@Json(name="store_name")
	val storeName: String? = null,

	@Json(name="subchannel_name")
	val subchannelName: String? = null,

	@Json(name="region_name")
	val regionName: String? = null,

	@Json(name="channel_id")
	val channelId: String? = null,

	@Json(name="longitude")
	val longitude: String? = null
)
