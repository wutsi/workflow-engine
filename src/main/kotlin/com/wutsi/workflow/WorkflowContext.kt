package com.wutsi.workflow

data class WorkflowContext(
    val accountId: Long? = null,
    val data: MutableMap<String, Any> = mutableMapOf()
)
