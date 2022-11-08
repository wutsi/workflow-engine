package com.wutsi.workflow.rule.account

import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.regulation.CountryRegulations
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class CountrySupportsBusinessAccountRule(
    private val account: Account,
    private val countryRegulations: CountryRegulations
) : Rule {
    override fun check() {
        if (!countryRegulations.getSupportCountryCodes().contains(account.country)) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.COUNTRY_NOT_SUPPORTED.urn,
                    data = mapOf(
                        "country" to account.country,
                        "supported-countries" to countryRegulations.getSupportCountryCodes()
                    )
                )
            )
        }
    }
}
