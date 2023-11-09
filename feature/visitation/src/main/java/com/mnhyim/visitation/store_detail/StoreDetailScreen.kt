package com.mnhyim.visitation.store_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.visitation.destinations.StoreVisitScreenDestination
import com.mnhyim.visitation.store_detail.components.StoreInfoSheet
import com.mnhyim.visitation.store_visit.components.StoreVisitNavArgs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navArgsDelegate = StoreDetailNavArgs::class)
@Composable
fun StoreDetailScreen(
    navigator: DestinationsNavigator
) {
    StoreDetailScreen(
        viewModel = hiltViewModel(),
        onVisitStoreButton = { navigator.navigate(StoreVisitScreenDestination(StoreVisitNavArgs(it))) }
    )
}

@Composable
internal fun StoreDetailScreen(
    viewModel: StoreDetailViewModel,
    onVisitStoreButton: (String) -> Unit
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(MaterialTheme.colorScheme.primary)
        )
        state.store?.let { store ->
            StoreInfoSheet(
                storeName = "${store.storeName} - ${store.storeId}",
                storeAddress = store.address,
                storeOutletType = store.channelName,
                storeDisplayType = store.areaName,
                storeDisplaySubType = store.subchannelName,
                ertm = "Ya",
                pareto = "Ya",
                eMerchandise = "Ya",
                onVisitStoreButton = { onVisitStoreButton(store.storeId) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}