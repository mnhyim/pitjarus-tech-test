package com.mnhyim.visitation.store_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navArgsDelegate = StoreDetailNavArgs::class)
@Composable
fun StoreDetailScreen(
    navigator: DestinationsNavigator
) {
    StoreDetailScreen(
        viewModel = hiltViewModel()
    )
}

@Composable
internal fun StoreDetailScreen(
    viewModel: StoreDetailViewModel
) {
    val state by viewModel.state.collectAsState()

    Column {
        Text(text = "${state.store?.storeId}")
    }
}