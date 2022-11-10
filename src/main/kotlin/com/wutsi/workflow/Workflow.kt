package com.wutsi.workflow

interface Workflow<Req, Resp> {
    fun execute(context: WorkflowContext<Req, Resp>)
}
