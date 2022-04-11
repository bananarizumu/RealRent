package com.banana.realrent.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.banana.realrent.ui.top.InputItemType

class TextFieldState(
    val inputItemType: InputItemType,
    private val validator: (String) -> Boolean = { true },
    ) {
    var text: String by mutableStateOf("")

    val isValid: Boolean
        get() = !(inputItemType.isMust && text.isEmpty())
}

