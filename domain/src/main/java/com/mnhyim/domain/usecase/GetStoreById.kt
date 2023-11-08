package com.mnhyim.domain.usecase

import com.mnhyim.domain.model.Store
import com.mnhyim.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStoreById @Inject constructor(
    private val repository: StoreRepository
) {
    operator fun invoke(id: String): Flow<Store> = repository.getStoreById(id)
}