package com.wutsi.workflow

class WorkflowContext(
    val request: Any? = null,
    val accountId: Long? = null
) {
    var response: Any? = null
}
