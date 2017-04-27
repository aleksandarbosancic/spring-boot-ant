package spring.boot.ant.websockets;

import spring.boot.ant.websockets.handlers.MyTextHandler;
import spring.boot.ant.websockets.handlers.MyBinaryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Autowired
    MyTextHandler myTextHandler;
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config)
    {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
    
    @Component
    public static class MyWebSocketConfigurer implements WebSocketConfigurer
    {

        @Autowired
        MyBinaryHandler binaryHandler;
        
        @Autowired
        MyTextHandler textHandler;
        
        public MyWebSocketConfigurer()
        {
        }
        
        

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
        {
//            registry.addHandler(new MyTextHandler(), "/text").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
//            registry.addHandler(new MyBinaryHandler(), "/binary").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();        
            registry.addHandler(textHandler, "/text").addInterceptors(new HttpSessionHandshakeInterceptor());
            registry.addHandler(binaryHandler, "/binary").addInterceptors(new HttpSessionHandshakeInterceptor());
        }
    }

}