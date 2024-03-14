package com.websocket.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class WebSocketProducer {

    @Inject
    @Channel("chat-out")
    Emitter<String> emitter;


    public void sendMessage(String message) {
        emitter.send(message);
    }
}
