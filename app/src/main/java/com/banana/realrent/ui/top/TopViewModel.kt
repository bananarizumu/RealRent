package com.banana.realrent.ui.top

import androidx.lifecycle.ViewModel
import com.banana.realrent.ui.TextFieldState

class TopViewModel(): ViewModel() {

    var topPageState = TopPageState(CostType.OTHERS.pageIndex)
    private val allItems: List<TextFieldState>
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

    fun incrementPage() {
        topPageState.currentQuestionIndex += 1
        topPageState.showDone = topPageState.currentQuestionIndex == topPageState.lastIndex
        topPageState.showPrevious = topPageState.currentQuestionIndex != 0
    }

    fun decrementPage() {
        topPageState.currentQuestionIndex -= 1
        topPageState.showDone = topPageState.currentQuestionIndex == topPageState.lastIndex
        topPageState.showPrevious = topPageState.currentQuestionIndex != 0
    }

    fun getInputItemsByPageIndex(pageIndex: Int): List<TextFieldState> {
       return allItems.filter { it.inputItemType.costType.pageIndex == pageIndex }
    }

    fun calculateRealRent(): Int {
        val initialCost = getInputItemsByPageIndex(CostType.INITIAL_COST.pageIndex).sumOf { it.text.toInt() }
        val totalMonthlyFee = topPageState.monthlyRent.text.toInt() * topPageState.residencePeriod.text.toInt()
        val totalRenewalFee = (topPageState.residencePeriod.text.toInt() / 12 / topPageState.contractPeriod.text.toInt()) * topPageState.renewalFee.text.toInt()
        return (initialCost + totalMonthlyFee + totalRenewalFee) / 10000
    }
}