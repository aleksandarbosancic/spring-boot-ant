/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.websockets.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author abosancic
 */
@Component
public class MyTextHandler extends TextWebSocketHandler
{

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {
        System.out.println("Received playload: "+ message.getPayload());
        session.sendMessage(new TextMessage("Echo : " + message.getPayload()));
    }

}
