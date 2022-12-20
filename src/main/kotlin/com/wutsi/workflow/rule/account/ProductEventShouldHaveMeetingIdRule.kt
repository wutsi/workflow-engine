package com.wutsi.workflow.rule.account

import com.wutsi.enums.ProductType
import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Product
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class ProductEventShouldHaveMeetingIdRule(
    private val product: Product,
) : Rule {
    override fun check() {
        if (
            product.type == ProductType.EVENT.name &&
            product.event?.online == true &&
            product.event?.meetingId.isNullOrEmpty()
        ) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PRODUCT_EVENT_NO_MEETING_ID.urn,
                    data = mapOf(
                        "product-id" to product.id,
                    ),
                ),
            )
        }
    }
}
