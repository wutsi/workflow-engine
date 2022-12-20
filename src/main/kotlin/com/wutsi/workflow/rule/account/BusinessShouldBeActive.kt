package com.wutsi.workflow.rule.account

import com.wutsi.checkout.access.dto.Business
import com.wutsi.enums.BusinessStatus
import com.wutsi.error.ErrorURN
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class BusinessShouldBeActive(
    private val business: Business,
) : Rule {
    override fun check() {
        if (business.status != BusinessStatus.ACTIVE.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.BUSINESS_NOT_ACTIVE.urn,
                    data = mapOf(
                        "business-id" to business.id,
                        "business-status" to business.status,
                    ),
                ),
            )
        }
    }
}
