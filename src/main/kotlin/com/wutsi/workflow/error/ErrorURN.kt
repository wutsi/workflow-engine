package com.wutsi.workflow.error

enum class ErrorURN(val urn: String) {
    BUSINESS_ACCOUNT_NOT_SUPPORTED_IN_COUNTRY("urn:wutsi:error:business-account-not-supported-in-country"),

    MEMBER_ALREADY_BUSINESS("urn:wutsi:error:member-already-business"),
    MEMBER_ALREADY_REGISTERED("urn:wutsi:error:member-already-registered"),
    MEMBER_SUSPENDED("urn:wutsi:error:member-suspended"),
    MEMBER_NOT_ACTIVE("urn:wutsi:error:member-not-active"),
    MEMBER_NOT_BUSINESS("urn:wutsi:error:member-not-business-account"),
    MEMBER_NOT_FOUND("urn:wutsi:error:member-not-found"),

    NO_STORE("urn:wutsi:error:no-store"),

    PHONE_NUMBER_ALREADY_ASSIGNED("urn:wutsi:error:phone-number-already-assigned"),

    PICTURE_LIMIT_REACHED("urn:wutsi:error:picture-limit-reached"),

    PRODUCT_NOT_FOUND("urn:wutsi:error:product-not-found"),
    PRODUCT_NOT_OWNER("urn:wutsi:error:product-not-owner"),
    PRODUCT_LIMIT_REACHED("urn:wutsi:error:product-limit-reached"),
    PRODUCT_PICTURE_MISSING("urn:wutsi:error:product-pictures-missing"),
    PRODUCT_NO_STOCK("urn:wutsi:error:product-no-store"),

    STORE_NOT_ACTIVE("urn:wutsi:error:store-not-active"),
    STORE_NOT_SUPPORTED_IN_COUNTRY("urn:wutsi:error:store-not-supported-in-country"),
    STORE_NOT_FOUND("urn:wutsi:error:store-not-found"),
    STORE_NOT_OWNER("urn:wutsi:error:store-not-owner")
}
