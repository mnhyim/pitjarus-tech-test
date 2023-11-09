package com.mnhyim.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.auth.components.LoginForm
import com.mnhyim.ui.components.GreyCircularProgressIndicator
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun AuthScreen(
    navigateToMainNavGraph: NavigateToMainNavGraph
) {
    AuthScreen(
        viewModel = hiltViewModel(),
        navigateToMainScreen = navigateToMainNavGraph::invoke
    )
}

@Composable
internal fun AuthScreen(
    viewModel: AuthViewModel,
    navigateToMainScreen: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    if (state.isLoggedIn) {
        LaunchedEffect(key1 = true) {
            navigateToMainScreen()
        }
    }

    if (state.isLoading) {
        GreyCircularProgressIndicator()
    }

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
//        Button(onClick = { navigateToMainScreen() }) {
//            Text(text = "TO MAIN")
//        }
    }

}