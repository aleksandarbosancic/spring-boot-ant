package spring.boot.ant.services;

/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import spring.boot.ant.models.Session;

/**
 *
 * @author abosancic
 */
@Component
public class SessionService extends BaseService
{
    static final Logger LOGGER = Logger.getLogger(SessionService.class.getName());
    
    public List<Session> getSessions()
    {
        return new ArrayList<Session>()
        {
            {
                add(new Session());
                add(new Session());
            }
        };
    }

    public Session getSession(String session_id, String designation)
    {
        LOGGER.log(Level.INFO, "getSession : {0}", session_id + " " + designation);
        return new Session();
    }
    
}
