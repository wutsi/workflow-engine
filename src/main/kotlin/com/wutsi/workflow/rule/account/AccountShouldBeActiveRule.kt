package com.wutsi.workflow.rule.account

import com.wutsi.enums.AccountStatus
import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class AccountShouldBeActiveRule(private val account: Account) : Rule {
    override fun check() {
        if (account.status != AccountStatus.ACTIVE.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.MEMBER_NOT_ACTIVE.urn
                )
            )
        }
    }
}
