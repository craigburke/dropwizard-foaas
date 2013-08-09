package com.craigburke.foaas.core

public class Message {

    final String message
    final String subtitle

    public Message(def template, String name, String from) {

        if (name) {
            this.message = String.format((String)template.message, name)
            this.subtitle = String.format((String)template.subtitle, from)
        }
        else {
            this.message = (String)template.message
            this.subtitle = String.format((String)template.subtitle, from)
        }


    }

    public String toString() {
        "${message} ${subtitle}"
    }


}
