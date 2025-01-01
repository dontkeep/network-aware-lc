package com.al.networkawarelazycolumn

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> NetworkAwareLazyColumn(
    items: List<T>,
    networkMonitor: NetworkMonitor,
    itemContent: @Composable LazyItemScope.(item: T, isClickable: Boolean, modifier: Modifier) -> Unit,
    modifier: Modifier = Modifier
) {
    val isConnected by networkMonitor.isConnected.collectAsState(initial = true)

    LazyColumn(
        modifier = modifier
    ) {
        items(items = items, key = { it as Any }) { item ->
            itemContent(item, isConnected, Modifier.padding(8.dp))
        }
    }
}