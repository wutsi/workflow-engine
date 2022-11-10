package com.wutsi.workflow.rule.account

import com.wutsi.marketplace.access.dto.Product
import com.wutsi.membership.access.dto.Account
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ForbiddenException
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class AccountShouldBeOwnerOfProductRule(private val account: Account, private val product: Product) : Rule {
    override fun check() {
        if (account.storeId != product.storeId) {
            throw ForbiddenException(
                error = Error(
                    code = ErrorURN.PRODUCT_NOT_OWNER.urn
                )
            )
        }
    }
}
