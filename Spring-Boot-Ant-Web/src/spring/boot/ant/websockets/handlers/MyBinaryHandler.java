/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.websockets.handlers;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

/**
 *
 * @author abosancic
 */
@Component
public class MyBinaryHandler extends BinaryWebSocketHandler
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
