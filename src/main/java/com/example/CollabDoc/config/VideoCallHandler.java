//package com.example.CollabDoc.config;
//
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class VideoCallHandler extends TextWebSocketHandler {
//
//    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        sessions.put(session.getId(), session);
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
//        for (WebSocketSession webSocketSession : sessions.values()) {
//            if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
//                webSocketSession.sendMessage(message);
//            }
//        }
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessions.remove(session.getId());
//    }
//}
