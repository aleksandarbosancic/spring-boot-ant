/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.controllers;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.ant.models.Quote;
import spring.boot.ant.services.QuoteService;

@RestController
public class QuoteController extends BaseController
{

    final static Logger LOGGER = Logger.getLogger(QuoteController.class.getName());
    
    @Autowired
    QuoteService quoteService;

    @ResponseBody
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    Quote getQuote() {
        
        return quoteService.getQuote();
    }

}
