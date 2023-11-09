package com.mnhyim.visitation.store_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StoreInfoSheet(
    storeName: String,
    storeAddress: String,
    storeOutletType: String,
    storeDisplayType: String,
    storeDisplaySubType: String,
    ertm: String,
    pareto: String,
    eMerchandise: String,
    onVisitStoreButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {

        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            StoreInfo(
                storeName = storeName,
                storeAddress = storeAddress,
                storeOutletType = storeOutletType,
                storeDisplayType = storeDisplayType,
                storeDisplaySubType = storeDisplaySubType,
                ertm = ertm,
                pareto = pareto,
                eMerchandise =eMerchandise,
                onVisitStoreButton = onVisitStoreButton
            )
        }
        Row(
            modifier = Modifier
                .offset(y = -12.dp)
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .background(MaterialTheme.colorScheme.secondary, CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .size(32.dp)
                    .padding(6.dp)
                    .clickable {  }
            )
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .background(MaterialTheme.colorScheme.secondary, CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .size(32.dp)
                    .padding(6.dp)
                    .clickable {  }
            )
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .background(MaterialTheme.colorScheme.secondary, CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .size(32.dp)
                    .padding(6.dp)
                    .clickable {  }
            )
        }
    }
}