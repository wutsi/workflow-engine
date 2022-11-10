package com.wutsi.workflow.rule.account

import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.regulation.CountryNotSupportedException
import com.wutsi.regulation.CountryRegulations
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class CountryShouldSupportBusinessAccountRule(
    private val account: Account,
    private val countryRegulations: CountryRegulations
) : Rule {
    override fun check() {
        val country = account.country
        try {
            if (!countryRegulations.get(country).supportsBusinessAccount) {
                throw notSupported(country)
            }
        } catch (ex: CountryNotSupportedException) {
            throw notSupported(country, ex)
        }
    }

    private fun notSupported(country: String, cause: Throwable? = null) = ConflictException(
        error = Error(
            code = ErrorURN.BUSINESS_ACCOUNT_NOT_SUPPORTED_IN_COUNTRY.urn,
            data = mapOf(
                "country" to country
            )
        ),
        cause
    )
}