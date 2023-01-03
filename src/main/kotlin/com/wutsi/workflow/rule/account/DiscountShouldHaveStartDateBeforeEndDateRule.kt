package com.wutsi.workflow.rule.account

import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Discount
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class DiscountShouldHaveStartDateBeforeEndDateRule(private val discount: Discount) : Rule {
    override fun check() {
        if (discount.ends != null && discount.starts != null && discount.ends!!.isBefore(discount.starts)) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.DISCOUNT_INVALID_DATE.urn,
                    data = mapOf(
                        "discount-id" to discount.id,
                    ),
                ),
            )
        }
    }
}
