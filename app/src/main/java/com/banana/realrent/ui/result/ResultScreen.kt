package com.banana.realrent.ui.result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.banana.realrent.ui.top.InputField
import com.banana.realrent.ui.top.TopViewModel

@Composable
fun ResultScreen() {
    Scaffold {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                textAlign = TextAlign.Center,
                                text = "Real Rent",
                            )
                        },
                    )
                },
            ) {
                Text(text = "result")
            }
    }
}


