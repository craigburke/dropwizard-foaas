package com.craigburke.foaas.health

import com.craigburke.foaas.core.Message

import com.yammer.metrics.core.HealthCheck
import com.yammer.metrics.core.HealthCheck.Result

public class TemplateHealthCheck extends HealthCheck {

    def template

    public TemplateHealthCheck(def template) {
        super('template')
        this.template = template
    }

    @Override
    protected Result check() throws Exception {


        Message message = new Message(template, 'You', 'Me')

        if (!message.message.contains('Fuck')) {
            return Result.unhealthy('template doesn\'t include Fuck. WTF?!?')
        }

        return Result.healthy()
    }



}
