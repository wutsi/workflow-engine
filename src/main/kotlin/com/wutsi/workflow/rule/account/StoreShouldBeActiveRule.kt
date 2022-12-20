package com.wutsi.workflow.rule.account

import com.wutsi.enums.StoreStatus
import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Store
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class StoreShouldBeActiveRule(private val store: Store) : Rule {
    override fun check() {
        if (store.status != StoreStatus.ACTIVE.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.STORE_NOT_ACTIVE.urn,
                    data = mapOf(
                        "store-id" to store.id,
                    ),
                ),
            )
        }
    }
}
