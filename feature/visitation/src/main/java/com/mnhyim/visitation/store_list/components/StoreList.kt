package com.mnhyim.visitation.store_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mnhyim.domain.model.Store

@Composable
fun StoreList(
    items: List<Store>,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "List kunjungan 19-08-2020",
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp),
            style = MaterialTheme.typography.titleSmall
        )
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = items) { store ->
                StoreItem(
                    storeId = store.storeId,
                    storeName = store.storeName,
                    storeCluster = store.storeCode,
                    storeType = store.address,
                    navigateToDetail = { navigateToDetail(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}