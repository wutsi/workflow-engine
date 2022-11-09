package com.wutsi.workflow

import com.wutsi.platform.core.stream.EventStream

abstract class AbstractWorkflow<T>(private val eventStream: EventStream) : Workflow {

    protected abstract fun getEventType(): String?
    protected abstract fun toEventPayload(context: WorkflowContext): T?
    protected abstract fun getValidationRules(context: WorkflowContext): RuleSet
    protected abstract fun doExecute(context: WorkflowContext)

    override fun execute(context: WorkflowContext) {
        validate(context)
        doExecute(context)
        val urn = getEventType()
        if (urn != null) {
            toEventPayload(context)?.let {
                eventStream.publish(urn, it)
            }
        }
    }

    private fun validate(context: WorkflowContext) {
        getValidationRules(context).check()
    }
}
