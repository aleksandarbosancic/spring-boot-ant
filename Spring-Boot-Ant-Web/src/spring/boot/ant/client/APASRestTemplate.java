/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.client;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;
import spring.boot.ant.config.Config;

/**
 *
 * @author abosancic
 */
@Component
public class APASRestTemplate
{

    Map<String, RestTemplate> templates;
    
    @Autowired
    Config config;
    
    @Autowired
    RestTemplateBuilder builder;

    @PostConstruct
    public void init()
    {
        templates = new HashMap<>();
        DefaultUriTemplateHandler handler = new DefaultUriTemplateHandler();
        handler.setBaseUrl("http://gturnquist-quoters.cfapps.io");
        RestTemplate restTemplate = builder.build();
        restTemplate.setUriTemplateHandler(handler);
        templates.put("gturnquist-quoters.cfapps.io", restTemplate);
    }
    
    public RestTemplate get(String impl)
    {
        return this.templates.get(impl);
    }
}
