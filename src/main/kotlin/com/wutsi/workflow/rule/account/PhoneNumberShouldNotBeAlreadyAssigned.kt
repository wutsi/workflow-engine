package com.wutsi.workflow.rule.account

import com.wutsi.membership.access.MembershipAccessApi
import com.wutsi.membership.access.dto.SearchAccountRequest
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class PhoneNumberShouldNotBeAlreadyAssigned(
    private val phoneNumber: String,
    private val membershipAccess: MembershipAccessApi
) : Rule {
    override fun check() {
        val accounts = membershipAccess.searchAccount(
            request = SearchAccountRequest(
                phoneNumber = phoneNumber
            )
        ).accounts

        if (accounts.isNotEmpty()) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PHONE_NUMBER_ALREADY_ASSIGNED.urn,
                    data = mapOf(
                        "phone-number" to phoneNumber
                    )
                )
            )
        }
    }
}
