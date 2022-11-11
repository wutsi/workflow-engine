package com.wutsi.workflow

interface Workflow<Req, Resp> {
    fun execute(request: Req, context: WorkflowContext): Resp
}
