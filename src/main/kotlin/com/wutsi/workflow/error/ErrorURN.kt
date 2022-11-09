package com.wutsi.workflow.error

enum class ErrorURN(val urn: String) {
    COUNTRY_NOT_SUPPORTED("urn:wutsi:error:country-not-supported"),

    MEMBER_ALREADY_BUSINESS("urn:wutsi:error:member-already-business"),
    MEMBER_ALREADY_REGISTERED("urn:wutsi:error:member-already-registered"),
    MEMBER_SUSPENDED("urn:wutsi:error:member-suspended"),
    MEMBER_NOT_ACTIVE("urn:wutsi:error:member-not-active"),
    MEMBER_NOT_BUSINESS("urn:wutsi:error:member-already-business"),
    MEMBER_NOT_FOUND("urn:wutsi:error:member-not-found"),

    PHONE_NUMBER_ALREADY_ASSIGNED("urn:wutsi:error:phone-number-already-assigned")
}
