package com.craigburke.foaas.views

import com.yammer.dropwizard.views.View

class IndexView extends View {

    public IndexView() {
        super('index.ftl')
    }
}
