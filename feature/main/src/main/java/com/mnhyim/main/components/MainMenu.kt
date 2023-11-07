package com.mnhyim.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainMenu() {
    Column {
        Text(
            text = "Menu",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        FlowRow(
            horizontalArrangement = Arrangement.Center,
            maxItemsInEachRow = 4,
            modifier = Modifier.fillMaxWidth()
        ) {
            MenuItems.values().forEach { menu ->
                MainMenuItem(
                    icon = menu.icon,
                    title = menu.title,
                    modifier = Modifier
                        .weight(weight = 0.25f, fill = false)
                        .clickable {
                            when (menu) {
                                MenuItems.VISITATION -> {}
                                MenuItems.INSTALL_TARGET -> {}
                                MenuItems.DASHBOARD -> {}
                                MenuItems.HISTORY -> {}
                                MenuItems.LOGOUT -> {}
                            }
                        }
                )
            }

        }
    }
}

@Composable
internal fun MainMenuItem(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .background(Color.Gray, CircleShape)
                .padding(12.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp)
        )
    }
}