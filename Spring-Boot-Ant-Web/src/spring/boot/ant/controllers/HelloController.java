/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abosancic
 */
@RestController
public class HelloController
{

    @RequestMapping("/hello")
    public String index()
    {
        return "Greetings from Spring Boot!";
    }

}
