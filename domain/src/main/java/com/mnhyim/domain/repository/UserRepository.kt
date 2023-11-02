package com.mnhyim.domain.repository

import com.mnhyim.domain.model.Store

interface UserRepository {

    suspend fun userLogin(username: String, password: String): List<Store>
}