package com.wutsi.workflow

import com.wutsi.platform.core.stream.EventStream

abstract class AbstractWorkflow<Req, Resp, Ev>(protected val eventStream: EventStream) : Workflow<Req, Resp> {
    protected abstract fun getEventType(request: Req, response: Resp, context: WorkflowContext): String?
    protected abstract fun toEventPayload(request: Req, response: Resp, context: WorkflowContext): Ev?
    protected abstract fun getValidationRules(request: Req, context: WorkflowContext): RuleSet
    protected abstract fun doExecute(request: Req, context: WorkflowContext): Resp

    override fun execute(request: Req, context: WorkflowContext): Resp {
        validate(request, context)
        val response = doExecute(request, context)
        val urn = getEventType(request, response, context)
        if (urn != null) {
            toEventPayload(request, response, context)?.let {
                eventStream.publish(urn, it)
            }
        }
        return response
    }

    private fun validate(request: Req, context: WorkflowContext) {
        getValidationRules(request, context).check()
    }
}
