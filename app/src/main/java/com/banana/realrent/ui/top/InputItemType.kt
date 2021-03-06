package com.banana.realrent.ui.top

import androidx.annotation.StringRes
import androidx.compose.ui.text.input.ImeAction
import com.banana.realrent.R
import com.banana.realrent.util.isValidNumber

enum class InputItemType(
    @StringRes val title: Int,
    val isMust: Boolean,
    @StringRes val unit: Int,
    val costType: CostType,
    val keyboardAction: ImeAction
) {
    MONTHLY_RENT(
        R.string.monthly_rent,
        true, R.string.unit_yen,
        CostType.MONTHLY_COST,
        ImeAction.Done
    ),
    SECURITY_DEPOSIT(
        R.string.security_deposit,
        false,
        R.string.unit_yen,
        CostType.INITIAL_COST,
        ImeAction.Next
    ),
    KEY_MONEY(
        R.string.key_money,
        false,
        R.string.unit_yen,
        CostType.INITIAL_COST,
        ImeAction.Next
    ),
    BROKERAGE_FEE(
        R.string.brokerage_fee,
        false,
        R.string.unit_yen,
        CostType.INITIAL_COST,
        ImeAction.Done
    ),
    RESIDENCE_PERIOD(
        R.string.regidence_period,
        true,
        R.string.unit_month,
        CostType.OTHERS,
        ImeAction.Next
    ),
    CONTRACT_PERIOD(
        R.string.contract_period,
        true,
        R.string.unit_year,
        CostType.OTHERS,
        ImeAction.Next
    ),
    RENEWAL_FEE(
        R.string.renewal_fee,
        true,
        R.string.unit_yen,
        CostType.OTHERS,
        ImeAction.Done
    );

    fun validator(value: String): Boolean {
        return value.isValidNumber(emptyEnabled = !this.isMust)
    }
}

enum class CostType(val pageIndex: Int, @StringRes val titleRes: Int) {
    MONTHLY_COST(0, R.string.monthly_cost_title),
    INITIAL_COST(1, R.string.initial_cost_title),
    OTHERS(2, R.string.other_cost_title)
}