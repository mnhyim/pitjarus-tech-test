package com.mnhyim.data.repository

import com.mnhyim.data.source.UserApi
import com.mnhyim.domain.model.Store
import com.mnhyim.domain.repository.UserRepository

class UserRepositoryImpl(
    private val api: UserApi
): UserRepository {

    override suspend fun userLogin(username: String, password: String): List<Store> {
        TODO("Not yet implemented")
    }
}