package com.mnhyim.domain.usecase

import com.mnhyim.domain.model.Store
import com.mnhyim.domain.repository.UserRepository
import com.mnhyim.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(username: String, password: String): Flow<Resource<List<Store>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.userLogin(
                username = username,
                password = password,
            )
            emit(Resource.Success(code = null, content = result))
        } catch (e: Exception) {
            emit(Resource.Error(code = null, message = e.localizedMessage))
        }
    }
}