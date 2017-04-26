/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.services;

import org.springframework.beans.factory.annotation.Autowired;
import spring.boot.ant.client.APASRestTemplate;

/**
 *
 * @author abosancic
 */
public class BaseService
{
    
    @Autowired
    protected APASRestTemplate holder;
    
}
