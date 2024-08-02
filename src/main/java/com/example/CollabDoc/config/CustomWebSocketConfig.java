package com.example.CollabDoc.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class CustomWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new RealTimeCollaborationHandler(), "/ws-custom").setAllowedOrigins("*");
//        registry.addHandler(new VideoCallHandler(), "/video-call").setAllowedOrigins("*");
    }
}