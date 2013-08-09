package com.craigburke.foaas.services

import com.craigburke.foaas.configuration.FOAASConfiguration
import com.craigburke.foaas.health.TemplateHealthCheck
import com.craigburke.foaas.resources.FOAASResource

import com.yammer.dropwizard.Service
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.views.ViewBundle
import com.yammer.dropwizard.assets.AssetsBundle

class FOAASService extends Service<FOAASConfiguration> {

    public static void main(String[] args) throws Exception {
        new FOAASService().run(args)
    }

    @Override
    public void initialize(Bootstrap<FOAASConfiguration> bootstrap) {
        bootstrap.setName('FOAAS')
        bootstrap.addBundle(new AssetsBundle())
        bootstrap.addBundle(new ViewBundle())
    }

    @Override
    public void run(FOAASConfiguration configuration, Environment environment)  {
        def templates = configuration.templates

        environment.addResource(new FOAASResource(templates))
        environment.addHealthCheck(new TemplateHealthCheck(templates['off']))
    }
}
