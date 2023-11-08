package com.mnhyim.visitation.store_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun StoreDetailScreen(
    navigator: DestinationsNavigator
) {
    StoreDetailScreen()
}

@Composable
internal fun StoreDetailScreen() {
    Column {
        Text(text = "Store Detail Screen")
    }
}