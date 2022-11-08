package com.wutsi.workflow

interface Workflow {
    fun execute(context: WorkflowContext)
}
