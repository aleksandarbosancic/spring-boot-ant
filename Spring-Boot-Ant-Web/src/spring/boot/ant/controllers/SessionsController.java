/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.controllers;

import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.ant.models.Session;
import spring.boot.ant.services.SessionService;

@RestController
public class SessionsController extends BaseController
{

    final static Logger LOGGER = Logger.getLogger(SessionsController.class.getName());

    @Autowired
    SessionService sessionService;
        
    @ResponseBody
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    List<Session> getSessions()
    {
        return sessionService.getSessions();
    }
    
    @ResponseBody
    @RequestMapping(value = "/session/{session_id}", method = RequestMethod.GET)
    Session getSession(@PathVariable String session_id, @RequestParam(value = "designation") String designation)
    {
        return sessionService.getSession(session_id, designation);
    }
    
    @RequestMapping(value = "/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}", method = RequestMethod.GET)
    String handle(@PathVariable String version, @PathVariable String extension)
    {
        return "version : " + version + " ,extension : " + extension;
    }
    
    @RequestMapping(value = "/spring/{type:png|jpg|jpeg|gif}", method = RequestMethod.GET)
    String handle1( 
            @ApiParam(value = "Allowed image types", required = true, allowableValues = "png,jpg,jpeg,gif")
            @PathVariable String type)
    {
        return "type : " + type;
    }

}
