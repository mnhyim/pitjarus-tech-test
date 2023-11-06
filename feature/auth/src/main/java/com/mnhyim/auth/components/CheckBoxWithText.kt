package com.mnhyim.auth.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CheckBoxWithText(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() },
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall
        )
    }
}