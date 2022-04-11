package com.banana.realrent.ui.result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen() {
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "真実の家賃は",
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                textAlign = TextAlign.Center,
                text = "800万円",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Red
                )
            )
            Text(
                textAlign = TextAlign.Center,
                text = "です",
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewResultScreen() {
    ResultScreen()
}
