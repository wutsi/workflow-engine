package com.wutsi.workflow.rule.account

import com.wutsi.marketplace.access.dto.Product
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule
import com.wutsi.workflow.error.ErrorURN

class ProductShouldHaveStockRule(
    private val product: Product
) : Rule {
    override fun check() {
        if (product.quantity != null && product.quantity == 0) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PRODUCT_NO_STOCK.urn,
                    data = mapOf(
                        "product-id" to product.id
                    )
                )
            )
        }
    }
}