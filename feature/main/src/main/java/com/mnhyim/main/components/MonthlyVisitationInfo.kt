package com.mnhyim.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MonthlyVisitationInfo(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = "Kunjungan pada bulan Agustus 2020",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            VisitationScore(
                icon = Icons.Default.KeyboardArrowLeft,
                title = "Total Score",
                score = "150",
                color = Color.Red,
                modifier = Modifier.weight(0.3f,false)
            )
            VisitationScore(
                icon = Icons.Default.KeyboardArrowDown,
                title = "Actual Score",
                score = "150",
                color = Color.Green,
                modifier = Modifier.weight(0.3f,false)
            )
            VisitationScore(
                icon = Icons.Default.KeyboardArrowRight,
                title = "Percentage",
                score = "150",
                color = Color.Yellow,
                modifier = Modifier.weight(0.3f,false)
            )
        }
    }
}

@Composable
internal fun VisitationScore(
    icon: ImageVector,
    title: String,
    score: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .background(color, CircleShape)
                    .padding(4.dp)
            )
            Text(
                text = score,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}