package spring.boot.ant.websockets;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;
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

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
        {
//            registry.addHandler(new MyTextHandler(), "/text").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
//            registry.addHandler(new MyBinaryHandler(), "/binary").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();        
            registry.addHandler(new MyTextHandler(), "/text").addInterceptors(new HttpSessionHandshakeInterceptor());
            registry.addHandler(new MyBinaryHandler(), "/binary").addInterceptors(new HttpSessionHandshakeInterceptor());
        }
    }

    @Component
    public static class MyTextHandler extends TextWebSocketHandler
    {
        
        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
        {
            session.sendMessage(new TextMessage("hello world"));
        }
        
    }
    
    @Component
    public static class MyBinaryHandler extends BinaryWebSocketHandler
    {
        @Override
        public void handleBinaryMessage(WebSocketSession session, BinaryMessage message)
        {
            try
            {
                ByteBuffer b = message.getPayload();
                String v = new String(b.array());
                System.out.println("paylod: " + v);
                //session.sendMessage(new BinaryMessage("hello world".getBytes()));
                byte[] image = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("static/" + "image" + ".png"));
                session.sendMessage(new BinaryMessage(image));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}