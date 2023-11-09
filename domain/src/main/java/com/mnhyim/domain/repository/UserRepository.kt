package com.mnhyim.domain.repository

import com.mnhyim.domain.model.Store
import com.mnhyim.domain.utils.Resource

interface UserRepository {

    suspend fun userLogin(username: String, password: String): Resource<List<Store>>
}