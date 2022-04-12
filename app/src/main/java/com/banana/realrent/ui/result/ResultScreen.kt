package com.banana.realrent.ui.result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banana.realrent.R

@Composable
fun ResultScreen(realRentValue: Int, onClickBackButton: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.app_name),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClickBackButton() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
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
                text = stringResource(id = R.string.real_rent_prefix),
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.real_rent_value, realRentValue),
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Red
                )
            )
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.real_rent_sufix),
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
    ResultScreen(300) {}
}
