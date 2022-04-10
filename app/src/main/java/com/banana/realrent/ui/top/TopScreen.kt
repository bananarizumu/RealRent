package com.banana.realrent.ui.top


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
import com.banana.realrent.ui.TextFieldState

@Composable
fun TopScreen(viewModel: TopViewModel) {
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
        LazyColumn() {
            items(viewModel.inputItems) { item ->
                InputField(textFieldState = item)
            }
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 8.dp)
                    ) {
                        Text(
                            "真実の家賃を計算する",
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InputField(textFieldState: TextFieldState) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        if (textFieldState.inputItemType.isMust) {
            Text(
                stringResource(id = R.string.must_label),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically),
                style = TextStyle(color = Color.Red, fontSize = 14.sp)
            )
        }
        Text(
            text = stringResource(id = textFieldState.inputItemType.title),
            modifier = Modifier
                .padding(end = 40.dp)
                .align(Alignment.CenterVertically),
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
        Column(
            modifier = Modifier
                .padding(end = 8.dp)
                .width(120.dp),
        ) {
            TextField(
                value = textFieldState.text,
                onValueChange = {
                    textFieldState.text = it
                },
                label = { Text("Label", fontSize = 14.sp) },
                modifier = Modifier.fillMaxWidth(),
                isError = textFieldState.isError,
                textStyle = TextStyle(fontSize = 8.sp, textAlign = TextAlign.End)
            )
            if (textFieldState.isError) {
                Text(
                    text = "Error message",
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Text(
            text = stringResource(id = textFieldState.inputItemType.unit),
            Modifier
//                .weight(1f, fill = false)
                .width(48.dp)
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp),
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
        )
    }
}

@Preview
@Composable
fun PreviewTopScreen() {
    val topViewModel = TopViewModel()
    TopScreen(topViewModel)
}

@Preview
@Composable
fun PreviewVariableForm() {
    Column {
        InputItemType.values().forEach {
            val textFieldState = TextFieldState(it)
            InputField(textFieldState)
        }
    }
}