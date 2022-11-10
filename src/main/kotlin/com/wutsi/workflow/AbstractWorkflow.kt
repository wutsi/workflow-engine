package com.wutsi.workflow

import com.wutsi.platform.core.stream.EventStream

abstract class AbstractWorkflow<Req, Resp, Ev>(private val eventStream: EventStream) : Workflow<Req, Resp> {
    protected abstract fun getEventType(): String?
    protected abstract fun toEventPayload(context: WorkflowContext<Req, Resp>): Ev?
    protected abstract fun getValidationRules(context: WorkflowContext<Req, Resp>): RuleSet
    protected abstract fun doExecute(context: WorkflowContext<Req, Resp>)

    override fun execute(context: WorkflowContext<Req, Resp>) {
        validate(context)
        doExecute(context)
        val urn = getEventType()
        if (urn != null) {
            toEventPayload(context)?.let {
                eventStream.publish(urn, it)
            }
        }
    }

    private fun validate(context: WorkflowContext<Req, Resp>) {
        getValidationRules(context).check()
    }
}
