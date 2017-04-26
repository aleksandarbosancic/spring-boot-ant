/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.config;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author abosancic
 */
@Component
@ConfigurationProperties
public class Config
{

    private static final Logger LOGGER = Logger.getLogger(Config.class.getName());
    
    private Testbean testbean;
    
    private List<String> endpoints = new ArrayList<>();
     
    @PostConstruct
    public void init()
    {
        LOGGER.log(Level.INFO, "property: {0}", new Object[]
        {
            this
        });
    }

    public Testbean getTestbean()
    {
        return testbean;
    }

    public void setTestbean(Testbean testbean)
    {
        this.testbean = testbean;
    }    

    public List<String> getEndpoints()
    {
        return endpoints;
    }

    public void setEndpoints(List<String> endpoints)
    {
        this.endpoints = endpoints;
    }
    
    public static class Testbean
    {

        private String name;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return "Testbean{" + "name=" + name + '}';
        }

    }

    @Override
    public String toString()
    {
        return "Config{" + "testbean=" + testbean + ", endpoints=" + endpoints + '}';
    }
    
}
