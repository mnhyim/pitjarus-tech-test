package com.mnhyim.visitation.store_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.visitation.destinations.StoreDetailScreenDestination
import com.mnhyim.visitation.store_detail.StoreDetailNavArgs
import com.mnhyim.visitation.store_list.components.OsmdroidMapView
import com.mnhyim.visitation.store_list.components.StoreList
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun StoreListScreen(
    navigator: DestinationsNavigator
) {
    StoreListScreen(
        viewModel = hiltViewModel(),
        navigateToDetailScreen = {
            navigator.navigate(StoreDetailScreenDestination(StoreDetailNavArgs(id = it)))
        }
    )
}

@Composable
internal fun StoreListScreen(
    viewModel: StoreListViewModel,
    navigateToDetailScreen: (String) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    Column {
        OsmdroidMapView(
            stores = state.stores,
            navigateToDetail = navigateToDetailScreen::invoke,
            modifier = Modifier.fillMaxHeight(0.5f)
        )
        StoreList(
            items = state.stores,
            navigateToDetail = navigateToDetailScreen::invoke,
            modifier = Modifier
        )
    }
}