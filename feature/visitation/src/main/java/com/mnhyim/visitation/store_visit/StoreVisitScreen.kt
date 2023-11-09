package com.mnhyim.visitation.store_visit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mnhyim.visitation.store_visit.components.StoreDashboardItem
import com.mnhyim.visitation.store_visit.components.StoreInfoCard
import com.mnhyim.visitation.store_visit.components.StoreVisitMenu
import com.mnhyim.visitation.store_visit.components.StoreVisitNavArgs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navArgsDelegate = StoreVisitNavArgs::class)
@Composable
fun StoreVisitScreen(
    navigator: DestinationsNavigator
) {
    StoreVisitScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        viewModel = hiltViewModel()
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun StoreVisitScreen(
    viewModel: StoreVisitViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier
    ) {
        state.stores?.let { store ->
            StoreInfoCard(
                storeCode = "${store.storeCode} - ${store.storeId}",
                storeName = store.storeName,
                storeCluster = store.channelName,
                storeInfo = store.dcName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        StoreVisitMenu()
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(7) {
                StoreDashboardItem()
            }
        }
    }
}