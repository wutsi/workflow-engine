package com.wutsi.workflow.rule.account

import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Store
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.regulation.RegulationEngine
import com.wutsi.workflow.Rule

class StoreShouldNotHaveTooManyProductsRule(
    private val store: Store,
    private val regulationEngine: RegulationEngine,
) : Rule {
    override fun check() {
        if (store.productCount >= regulationEngine.maxProducts()) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PRODUCT_LIMIT_REACHED.urn,
                    data = mapOf(
                        "store-id" to store.id,
                    ),
                ),
            )
        }
    }
}
