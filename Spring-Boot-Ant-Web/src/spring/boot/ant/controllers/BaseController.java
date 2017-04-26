/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.boot.ant.client.APASRestTemplate;
import spring.boot.ant.config.Config;

@RequestMapping("/api")
class BaseController
{
    @Autowired
    Config config;

    @Autowired
    APASRestTemplate holder;
    
}
