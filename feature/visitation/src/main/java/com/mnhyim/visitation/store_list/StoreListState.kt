package com.mnhyim.visitation.store_list

import com.mnhyim.domain.model.Store

data class StoreListState(
    val stores: List<Store> = emptyList()
)