package com.mnhyim.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.main.components.MainMenu
import com.mnhyim.main.components.MonthlyVisitationInfo
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen() {
    MainScreen(
        viewModel = hiltViewModel()
    )
}

@Composable
internal fun MainScreen(
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        MonthlyVisitationInfo(modifier = Modifier.fillMaxWidth())
        MainMenu()
    }
}