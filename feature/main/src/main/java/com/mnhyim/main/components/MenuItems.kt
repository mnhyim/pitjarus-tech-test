package com.mnhyim.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.ui.graphics.vector.ImageVector

enum class MenuItems(
    val icon: ImageVector,
    val title: String,
) {
    VISITATION(
        icon = Icons.Default.Home,
        title = "Kunjungan",
    ),
    INSTALL_TARGET(
        icon = Icons.Default.List,
        title = "Target Install CDFDPC"
    ),
    DASHBOARD(
        icon = Icons.Default.Email,
        title = "Dashboard"
    ),
    HISTORY(
        icon = Icons.Default.List,
        title = "Transmission History"
    ),
    LOGOUT(
        icon = Icons.Default.ExitToApp,
        title = "Logout"
    )
}