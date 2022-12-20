package com.wutsi.workflow.rule.account

import com.wutsi.enums.ProductType
import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Product
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule
import java.time.OffsetDateTime

class ProductEventShouldHaveStartDateInFutureRule(
    private val product: Product,
) : Rule {
    override fun check() {
        if (
            product.type == ProductType.EVENT.name &&
            product.event?.starts?.isBefore(OffsetDateTime.now()) == true
        ) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PRODUCT_EVENT_START_DATE_IN_PAST.urn,
                    data = mapOf(
                        "product-id" to product.id,
                    ),
                ),
            )
        }
    }
}
