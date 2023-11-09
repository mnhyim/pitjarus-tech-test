package com.mnhyim.visitation.store_visit.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

enum class  StoreVisitMenuItems(
    val icon: ImageVector,
    val title: String,
) {
    INFORMATION(
        icon = Icons.Default.Home,
        title = "Information",
    ),
    PRODUCT_CHECK(
        icon = Icons.Default.List,
        title = "Product Check"
    ),
    SKU_PROMO(
        icon = Icons.Default.Email,
        title = "SKU Promo"
    ),
    RINGKASAN_OOS(
        icon = Icons.Default.List,
        title = "Ringkasan OOS"
    ),
    STORE_INVESTMENT(
        icon = Icons.Default.ExitToApp,
        title = "Store Investment"
    )
}