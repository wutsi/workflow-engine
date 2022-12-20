package com.wutsi.workflow.rule.account

import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Product
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.regulation.RegulationEngine
import com.wutsi.workflow.Rule

class ProductShouldNotHaveTooManyPicturesRule(
    private val product: Product,
    private val regulationEngine: RegulationEngine,
) : Rule {
    override fun check() {
        if (product.pictures.size >= regulationEngine.maxPictures()) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PICTURE_LIMIT_REACHED.urn,
                    data = mapOf(
                        "product-id" to product.id,
                    ),
                ),
            )
        }
    }
}
