package com.banana.realrent.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.banana.realrent.ui.top.InputItemType

class TextFieldState(
    val inputItemType: InputItemType
) {
    var text: String by mutableStateOf("")

    var hasAlreadyFocused: Boolean = false

    val isValid: Boolean
        get() = inputItemType.validator(text)

    val shouldDisplayError: Boolean
        get() = hasAlreadyFocused && !isValid
}

