package com.wutsi.workflow.rule.account

import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class AccountShouldHaveStoreRule(private val account: Account) : Rule {
    override fun check() {
        if (account.storeId == null) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.NO_STORE.urn
                )
            )
        }
    }
}