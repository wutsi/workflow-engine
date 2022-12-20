package com.wutsi.workflow.rule.account

import com.wutsi.checkout.access.dto.Order
import com.wutsi.error.ErrorURN
import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ForbiddenException
import com.wutsi.workflow.Rule

class AccountShouldBeOwnerOfOrder(private val account: Account, private val order: Order) : Rule {
    override fun check() {
        if (account.businessId != order.business.id) {
            throw ForbiddenException(
                error = Error(
                    code = ErrorURN.ORDER_NOT_OWNER.urn,
                    data = mapOf(
                        "account-id" to account.id,
                        "order-id" to order.id,
                    ),
                ),
            )
        }
    }
}
