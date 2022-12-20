package com.wutsi.workflow.rule.account

import com.wutsi.checkout.access.dto.PaymentMethod
import com.wutsi.error.ErrorURN
import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ForbiddenException
import com.wutsi.workflow.Rule

class AccountShouldBeOwnerOfPaymentMethodRule(private val account: Account, private val paymentMethod: PaymentMethod) :
    Rule {
    override fun check() {
        if (account.id != paymentMethod.accountId) {
            throw ForbiddenException(
                error = Error(
                    code = ErrorURN.PAYMENT_METHOD_NOT_OWNER.urn,
                    data = mapOf(
                        "account-id" to account.id,
                        "payment-method-token" to paymentMethod.token,
                    ),
                ),
            )
        }
    }
}
