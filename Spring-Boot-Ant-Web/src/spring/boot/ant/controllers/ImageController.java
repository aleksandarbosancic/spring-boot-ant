/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.controllers;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController extends BaseController
{

    private final static Logger LOGGER = Logger.getLogger(ImageController.class.getName());

    @ResponseBody
    @RequestMapping(value = "/image/{image:.*}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    byte[] testphoto(@PathVariable("image") String image, HttpServletResponse response) throws IOException
    {
        try
        {
            //File file = new ClassPathResource("static/image.png").getFile();
            return IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("static/" + image + ".png"));
        }
        catch (Exception e)
        {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

}
