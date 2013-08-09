package com.craigburke.foaas.views

import com.craigburke.foaas.core.Message

import com.yammer.dropwizard.views.View

public class FuckOffView extends View {

    final Message message

    public FuckOffView(Message message) {
        super('fuckoff.ftl')
        this.message = message
    }

}

