package com.craigburke.foaas.resources

import com.craigburke.foaas.core.Message
import com.craigburke.foaas.views.FuckOffView
import com.craigburke.foaas.views.IndexView

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response.Status
import javax.ws.rs.core.MediaType
import javax.ws.rs.WebApplicationException


@Path('/')
class FOAASResource {

    private final TEMPLATES

    public FOAASResource(def templates) {
        this.TEMPLATES = templates
    }

    @GET
    @Path('/')
    @Produces(MediaType.TEXT_HTML)
    public IndexView index() {
        return new IndexView()
    }

    @GET
    @Path('/{type}/{name}/{from}')
    @Produces(MediaType.TEXT_HTML)
    public FuckOffView fuckYou(@PathParam('type')  String type,
                            @PathParam('name') String name,
                            @PathParam('from') String from) {

        def message = getMessage(type, name, from)

        if (!message) {
            throw new WebApplicationException(Status.NOT_FOUND)
        }

        new FuckOffView(message)
    }

    @GET
    @Path('/{type}/{name}/{from}')
    @Produces(MediaType.APPLICATION_JSON)
    public Message fuckYouAsJson(@PathParam('type')  String type,
                               @PathParam('name') String name,
                               @PathParam('from') String from) {

        def message = getMessage(type, name, from)

        if (!message) {
            throw new WebApplicationException(Status.NOT_FOUND)
        }

        message
    }

    @GET
    @Path('/{type}/{name}/{from}')
    @Produces(MediaType.TEXT_PLAIN)
    public String fuckYouAsText(@PathParam('type')  String type,
                              @PathParam('name') String name,
                              @PathParam('from') String from) {

        def message = getMessage(type, name, from)

        if (!message) {
            throw new WebApplicationException(Status.NOT_FOUND)
        }

        message.toString()
    }


    private Message getMessage(String type, String name, String from ) {
        def template = TEMPLATES[type]
        new Message(template, name, from)
    }



}


