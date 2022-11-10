package com.wutsi.workflow

class WorkflowContext<Req, Resp>(
    val request: Req? = null,
    val accountId: Long? = null
) {
    var response: Resp? = null
}
