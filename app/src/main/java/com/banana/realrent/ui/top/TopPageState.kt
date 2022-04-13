package com.banana.realrent.ui.top

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.banana.realrent.ui.TextFieldState

data class TopPageState(
    val lastIndex: Int,
) {
    val monthlyRent = TextFieldState(InputItemType.MONTHLY_RENT)
    val securityDeposit = TextFieldState(InputItemType.SECURITY_DEPOSIT)
    val keyMoney = TextFieldState(InputItemType.KEY_MONEY)
    val residencePeriod = TextFieldState(InputItemType.RESIDENCE_PERIOD)
    val contractPeriod = TextFieldState(InputItemType.CONTRACT_PERIOD)
    val renewalFee = TextFieldState(InputItemType.RENEWAL_FEE)
    val brokerageFee = TextFieldState(InputItemType.BROKERAGE_FEE)
    var currentQuestionIndex by mutableStateOf(0)
    var showPrevious by mutableStateOf(false)
    var showDone by mutableStateOf(false)
}
