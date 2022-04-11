package com.banana.realrent.ui.top

import androidx.lifecycle.ViewModel
import com.banana.realrent.ui.TextFieldState

class TopViewModel(): ViewModel() {

    var topPageState = TopPageState()
    val inputItems: List<TextFieldState>
    get() {
        return listOf(
            topPageState.monthlyRent,
            topPageState.securityDeposit,
            topPageState.keyMoney,
            topPageState.residencePeriod,
            topPageState.contractPeriod,
            topPageState.renewalFee,
            topPageState.brokerageFee
        )
    }

    fun calculatRealRent(): Int {
        val initialCost = inputItems.filter { it.inputItemType.costType == CostType.INITIAL_COST }.sumOf { it.text.toInt() }
        val totalMonthlyFee = topPageState.monthlyRent.text.toInt() * topPageState.residencePeriod.text.toInt()
        val totalRenewalFee = (topPageState.residencePeriod.text.toInt() / 12 / topPageState.contractPeriod.text.toInt()) * topPageState.renewalFee.text.toInt()
        return initialCost + totalMonthlyFee + totalRenewalFee
    }
}