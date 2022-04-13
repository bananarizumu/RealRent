package com.banana.realrent.ui.top

import androidx.annotation.StringRes
import com.banana.realrent.R

enum class InputItemType(@StringRes val title: Int,
                         val isMust: Boolean,
                         @StringRes val unit: Int,
                         val costType: CostType
) {
    MONTHLY_RENT(R.string.monthly_rent, true, R.string.unit_yen, CostType.MONTHLY_COST),
    SECURITY_DEPOSIT(R.string.security_deposit, true, R.string.unit_yen, CostType.INITIAL_COST),
    KEY_MONEY(R.string.key_money, false, R.string.unit_yen, CostType.INITIAL_COST),
    BROKERAGE_FEE(R.string.brokerage_fee, false, R.string.unit_yen, CostType.INITIAL_COST),
    RESIDENCE_PERIOD(R.string.regidence_period, true, R.string.unit_month, CostType.OTHERS),
    CONTRACT_PERIOD(R.string.contract_period, true, R.string.unit_year, CostType.OTHERS),
    RENEWAL_FEE(R.string.renewal_fee, true, R.string.unit_yen, CostType.OTHERS),
}

enum class CostType(val pageIndex: Int) {
    MONTHLY_COST(0),
    INITIAL_COST(1),
    OTHERS(2)
}