/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import spring.boot.ant.models.HelloMessage;

@Controller
public class ImageController
{

    private final static Logger LOGGER = Logger.getLogger(ImageController.class.getName());

//    @MessageMapping("/images")
//    @SendTo("/topic/images")
//    public byte[] testphoto(HelloMessage message) throws IOException, Exception
//    {
//        try
//        {
//            return IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("static/" + message.getName() + ".png"));
//        }
//        catch (Exception e)
//        {
//            return null;
//        }
//    }
    
    @MessageMapping("/images")
    @SendTo("/topic/images")
    public String testphoto1(HelloMessage message) throws IOException, Exception
    {
        try
        {
            byte[] image = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("static/" + message.getName() + ".png"));
            return "data:image/png;base64,".concat(Base64.getEncoder().encodeToString(image));
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
