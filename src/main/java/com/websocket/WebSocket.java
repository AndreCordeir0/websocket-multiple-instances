package com.websocket;

import com.websocket.producer.WebSocketProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/web-socket/chat/{name}")
@ApplicationScoped
public class WebSocket {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    WebSocketProducer webSocketProducer;
    public WebSocket(WebSocketProducer webSocketProducer) {
        this.webSocketProducer = webSocketProducer;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) {
        System.out.println("onOpen> " + name);
        sessions.put(name, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("name") String name) {
        System.out.println("onClose> " + name);
        sessions.remove(name);
    }

    @OnError
    public void onError(Session session, @PathParam("name") String name, Throwable throwable) {
        System.out.println("onError> " + name + ": " + throwable);
        sessions.remove(name);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("name") String name) {
        System.out.println("onMessage> " + name + ": " + message);
        webSocketProducer.sendMessage("name: " + name + "message: " + message);
    }

    public void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                } else if (result.isOK()) {
                    System.out.println("Is ok, message: " + message);
                }
            });
        });
    }
}
