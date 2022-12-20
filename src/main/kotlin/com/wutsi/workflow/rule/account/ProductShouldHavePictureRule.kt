package com.wutsi.workflow.rule.account

import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Product
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class ProductShouldHavePictureRule(
    private val product: Product,
) : Rule {
    override fun check() {
        if (product.pictures.isEmpty()) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PRODUCT_PICTURE_MISSING.urn,
                    data = mapOf(
                        "product-id" to product.id,
                    ),
                ),
            )
        }
    }
}
