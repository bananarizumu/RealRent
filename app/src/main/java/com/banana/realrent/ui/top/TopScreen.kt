package com.banana.realrent.ui.top


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banana.realrent.R
import com.banana.realrent.ui.TextFieldState

@Composable
fun TopScreen(viewModel: TopViewModel, toResultScreen: (Int) -> Unit = {}) {
    val state = remember {
        viewModel.topPageState
    }
    val items = viewModel.getInputItemsByPageIndex(state.currentQuestionIndex)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.app_name),
                    )
                },
            )
        },
        bottomBar = {
            BottomBar(
                topPageState = viewModel.topPageState,
                enableNext = items.all { it.isValid },
                onClickNext = { viewModel.incrementPage() },
                onClickBack = { viewModel.decrementPage() },
                onClickDone = { toResultScreen(viewModel.calculateRealRent()) }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 24.dp)
                        .height(48.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    val headerTitleRes = CostType.values().firstOrNull { it.pageIndex == state.currentQuestionIndex }?.titleRes ?: return@Box
                    Text(
                        text = stringResource(id = R.string.input_header, stringResource(id = headerTitleRes)),
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 16.sp,
                        )
                    )
                }
            }

            items(items) { item ->
                InputField(textFieldState = item)
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
                label = { Text(stringResource(id = R.string.input_label), fontSize = 10.sp) },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        if (it.isFocused) textFieldState.hasAlreadyFocused = true
                    },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = textFieldState.shouldDisplayError,
                textStyle = TextStyle(fontSize = 8.sp, textAlign = TextAlign.End),
            )
            if (textFieldState.shouldDisplayError) {
                Text(
                    text = stringResource(id = R.string.input_error_message),
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
        Text(
            text = stringResource(id = textFieldState.inputItemType.unit),
            Modifier
                .width(48.dp)
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp),
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun BottomBar(
    topPageState: TopPageState,
    enableNext: Boolean,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
    onClickDone: () -> Unit
) {
    Surface(
        elevation = 7.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            if (topPageState.showPrevious) {
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    onClick = onClickBack,
                ) {
                    Text(text = stringResource(id = R.string.back_button))
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                onClick =
                {
                    if (topPageState.showDone) {
                        onClickDone()
                    } else {
                        onClickNext()
                    }
                },
                enabled = enableNext
            ) {
                Text(
                    stringResource(id = if (topPageState.showDone) R.string.caluclate_real_rent else R.string.next_button),
                )
            }


        }
    }
}

@Preview
@Composable
fun PreviewBottomBar() {
    BottomBar(topPageState = TopPageState(0),
        enableNext = true,
        onClickNext = {},
        onClickDone = {},
        onClickBack = {}
    )
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