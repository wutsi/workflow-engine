package com.wutsi.workflow.rule.account

import com.wutsi.checkout.access.dto.Order
import com.wutsi.enums.OrderStatus
import com.wutsi.error.ErrorURN
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class OrderShouldNotBeExpiredRule(
    private val order: Order,
) : Rule {
    override fun check() {
        if (order.status == OrderStatus.EXPIRED.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.ORDER_EXPIRED.urn,
                    data = mapOf(
                        "order-id" to order.id,
                    ),
                ),
            )
        }
    }
}
