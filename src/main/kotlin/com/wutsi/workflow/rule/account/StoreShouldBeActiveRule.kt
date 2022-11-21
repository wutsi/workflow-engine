package com.wutsi.workflow.rule.account

import com.wutsi.marketplace.access.dto.Store
import com.wutsi.membership.access.enums.AccountStatus
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class StoreShouldBeActiveRule(private val store: Store) : Rule {
    override fun check() {
        if (store.status != AccountStatus.ACTIVE.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.STORE_NOT_ACTIVE.urn,
                    data = mapOf(
                        "store-id" to store.id
                    )
                )
            )
        }
    }
}
