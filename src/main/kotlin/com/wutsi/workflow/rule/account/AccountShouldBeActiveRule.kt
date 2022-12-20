package com.wutsi.workflow.rule.account

import com.wutsi.enums.AccountStatus
import com.wutsi.error.ErrorURN
import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class AccountShouldBeActiveRule(private val account: Account) : Rule {
    override fun check() {
        if (account.status != AccountStatus.ACTIVE.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.MEMBER_NOT_ACTIVE.urn,
                    data = mapOf(
                        "account-id" to account.id,
                        "account-status" to account.status,
                    ),
                ),
            )
        }
    }
}
