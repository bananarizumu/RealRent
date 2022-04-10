package com.banana.realrent.ui.top

import androidx.compose.runtime.mutableStateOf
import com.banana.realrent.ui.TextFieldState

class TopPageState() {
    val monthlyRent = TextFieldState(InputItemType.MONTHLY_RENT)
    val SECURITY_DEPOSIT = TextFieldState(InputItemType.SECURITY_DEPOSIT)
    val keyMoney = TextFieldState(InputItemType.KEY_MONEY)
    val residencePeriod = TextFieldState(InputItemType.RESIDENCE_PERIOD)
    val contractPeriod = TextFieldState(InputItemType.CONTRACT_PERIOD)
    val renewalFee = TextFieldState(InputItemType.RENEWAL_FEE)
    val brokerageFee = TextFieldState(InputItemType.BROKERAGE_FEE)
}
