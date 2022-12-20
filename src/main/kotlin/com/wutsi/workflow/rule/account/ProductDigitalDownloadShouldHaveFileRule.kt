package com.wutsi.workflow.rule.account

import com.wutsi.enums.ProductType
import com.wutsi.error.ErrorURN
import com.wutsi.marketplace.access.dto.Product
import com.wutsi.platform.core.error.Error
import com.wutsi.platform.core.error.exception.ConflictException
import com.wutsi.workflow.Rule

class ProductDigitalDownloadShouldHaveFileRule(
    private val product: Product,
) : Rule {
    override fun check() {
        if (
            product.type == ProductType.DIGITAL_DOWNLOAD.name &&
            product.files.isEmpty()
        ) {
            throw ConflictException(
                error = Error(
                    code = ErrorURN.PRODUCT_DIGITAL_DOWNLOAD_NO_FILE.urn,
                    data = mapOf(
                        "product-id" to product.id,
                    ),
                ),
            )
        }
    }
}
