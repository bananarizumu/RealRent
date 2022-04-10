package com.banana.realrent.ui.top

import androidx.annotation.StringRes
import com.banana.realrent.R

enum class InputItemType(@StringRes val title: Int, val isMust: Boolean, @StringRes val unit: Int) {
    MONTHLY_RENT(R.string.monthly_rent, true, R.string.unit_yen),
    SECURITY_DEPOSIT(R.string.security_deposit, true, R.string.unit_yen),
    KEY_MONEY(R.string.key_money, false, R.string.unit_yen),
    BROKERAGE_FEE(R.string.brokerage_fee, false, R.string.unit_yen),
    RESIDENCE_PERIOD(R.string.regidence_period, true, R.string.unit_month),
    CONTRACT_PERIOD(R.string.contract_period, true, R.string.unit_year),
    RENEWAL_FEE(R.string.renewal_fee, true, R.string.unit_yen),
}