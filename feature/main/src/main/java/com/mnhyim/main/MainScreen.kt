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

@Destination(start = true)
@Composable
fun MainScreen(
    navigateToVisitationNavGraph: NavigateToVisitationNavGraph
) {
    MainScreen(
        navigateToVisitationScreen = navigateToVisitationNavGraph::invoke,
        viewModel = hiltViewModel()
    )
}

@Composable
internal fun MainScreen(
    navigateToVisitationScreen: () -> Unit,
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        MonthlyVisitationInfo(
            modifier = Modifier.fillMaxWidth()
        )
        MainMenu(
            navigateToVisitationScreen = navigateToVisitationScreen,
        )
    }
}