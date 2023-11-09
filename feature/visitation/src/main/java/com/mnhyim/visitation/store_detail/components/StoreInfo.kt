package com.mnhyim.visitation.store_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StoreInfo(
    storeName: String,
    storeAddress: String,
    storeOutletType: String,
    storeDisplayType: String,
    storeDisplaySubType: String,
    ertm: String,
    pareto: String,
    eMerchandise: String,
    onVisitStoreButton: () -> Unit
) {
    Column(
        modifier = Modifier.padding(12.dp, 12.dp, 12.dp, 27.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Lokasi belum sesuai",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 8.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset")
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = storeName,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = storeAddress,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Tipe Outlet",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(0.5f)
            )
            Text(
                text = ":$storeOutletType",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(0.5f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Tipe Display",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(0.5f)
            )
            Text(
                text = ":$storeDisplayType",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(0.5f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Sub Tipe Display",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(0.5f)
            )
            Text(
                text = ":$storeDisplaySubType",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(0.5f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "ERTM",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(0.5f)
            )
            Text(
                text = ":ertm",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(0.5f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Pareto",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(0.5f)
            )
            Text(
                text = ":$pareto",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(0.5f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "E-merchandising",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .weight(0.5f)
            )
            Text(
                text = ":$eMerchandise",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(0.5f)
            )
        }

        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .weight(0.5f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "No Visit")
            }
            Button(
                onClick = { onVisitStoreButton() },
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text = "Visit")
            }
        }
    }
}