package com.banana.realrent.ui.top

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.banana.realrent.ui.TextFieldState

class TopViewModel(): ViewModel() {

    var topPageState = TopPageState()

    val inputItems: List<TextFieldState>
    get() {
        return listOf(
            topPageState.monthlyRent,
            topPageState.SECURITY_DEPOSIT,
            topPageState.keyMoney,
            topPageState.residencePeriod,
            topPageState.contractPeriod,
            topPageState.renewalFee,
            topPageState.brokerageFee
        )
    }
}