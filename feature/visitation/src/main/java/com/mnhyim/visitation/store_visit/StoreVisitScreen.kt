package com.mnhyim.visitation.store_visit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun StoreVisitScreen(
    navigator: DestinationsNavigator
) {
    StoreVisitScreen()
}

@Composable
internal fun StoreVisitScreen() {
    Column {
        Text(text = "Store Visit Screen")
    }
}