package com.al.networkawarelazycolumn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.al.networkawarelazycolumn.ui.theme.MyApplicationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    private lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        networkMonitor = NetworkMonitor(applicationContext)

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val items = remember { listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16") }

                    LaunchedEffect(Unit) {
                        fetchDataInBackground()
                    }

                    NetworkAwareLazyColumn(
                        items = items,
                        networkMonitor = networkMonitor,
                        modifier = Modifier.padding(innerPadding),
                        itemContent = { item, isClickable, paddingModifier ->
                            Card(
                                modifier = paddingModifier
                                    .fillMaxWidth()
                                    .clickable(enabled = isClickable) {
                                        Toast.makeText(this@MainActivity, "Clicked: $item", Toast.LENGTH_SHORT).show()
                                    },
                                shape = RoundedCornerShape(8.dp), // Rounded corners for card
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 2.dp
                                ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                )
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text(
                                        text = "Title: $item",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = "This is a subtitle for $item.",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

private suspend fun fetchDataInBackground() {
    withContext(Dispatchers.IO) {
        delay(2000)
        println("Data fetched from network on background thread.")
    }
}
