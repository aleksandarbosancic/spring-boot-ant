/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant;

import org.springframework.stereotype.Component;

/**
 *
 * @author abosancic
 */
@Component
public class DemoService
{
    private String name = "default";
    
    public void print()
    {
        System.out.println("name: " + name);
    }
    
}
