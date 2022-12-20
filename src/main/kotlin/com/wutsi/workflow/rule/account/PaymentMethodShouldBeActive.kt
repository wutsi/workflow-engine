package com.wutsi.workflow.rule.account

import com.wutsi.checkout.access.dto.PaymentMethod
import com.wutsi.enums.PaymentMethodStatus
import com.wutsi.error.ErrorURN
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class PaymentMethodShouldBeActive(
    private val paymentMethod: PaymentMethod,
) : Rule {
    override fun check() {
        if (paymentMethod.status != PaymentMethodStatus.ACTIVE.name) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PAYMENT_METHOD_NOT_ACTIVE.urn,
                ),
            )
        }
    }
}
