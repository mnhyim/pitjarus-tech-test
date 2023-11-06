package com.mnhyim.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.auth.components.LoginForm
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LoginForm(
            username = state.username,
            password = state.password,
            onUsernameFieldChange = viewModel::inputUsername,
            onPasswordFieldChange = viewModel::inputPassword,
            onLogin = viewModel::userLogin,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(CenterHorizontally)
        )
    }

    if (state.isLoading) {
        Box(
            contentAlignment = Center,
            modifier = Modifier.fillMaxSize().background(Color.LightGray)
        ) {
            CircularProgressIndicator()
        }
    }
}