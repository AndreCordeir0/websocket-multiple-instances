package com.websocket.consumer;

import com.websocket.WebSocket;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class WebSocketConsumer {
    WebSocket webSocket;
    public WebSocketConsumer(WebSocket webSocket) {
        this.webSocket = webSocket;
    }

    @Incoming("chat-in")
    public void getMessages(String message) {
        webSocket.broadcast(message);
    }
}
