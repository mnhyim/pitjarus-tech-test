package com.mnhyim.auth

data class AuthState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,

    val username: String = "",
    val password: String = ""
)