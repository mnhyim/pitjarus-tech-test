package com.mnhyim.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.domain.usecase.AuthUseCases
import com.mnhyim.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun userLogin() {
        authUseCases.loginUseCase(
            username = state.value.username,
            password = state.value.password
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    if (result.code == 200) {
                        changeLoginStatus(true)
                        changeLoadingStatus(false)
                        Timber.d("userLogin - Success")
                    }
                }

                is Resource.Loading -> {
                    changeLoadingStatus(true)
                    Timber.d("userLogin - Loading")
                }

                is Resource.Error -> {
                    changeLoadingStatus(false)
                    changeLoginStatus(false)
                    Timber.d("userLogin - Error - ${result.message}")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun inputUsername(username: String) = _state.update { it.copy(username = username) }
    fun inputPassword(password: String) = _state.update { it.copy(password = password) }

    private fun changeLoadingStatus(status: Boolean) = _state.update { it.copy(isLoading = status) }
    private fun changeLoginStatus(status: Boolean) = _state.update { it.copy(isLoggedIn = status) }
}