/*
 * Copyright (c) 2017
 * AlphaGate Automatisierungstechnik, Rankweil, Austria  * 
 * @author      original: abo, last edit: $Author$
 * @version     $Id$
 */
package spring.boot.ant.services;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import spring.boot.ant.models.Quote;

/**
 *
 * @author abosancic
 */
@Component
public class QuoteService extends BaseService
{

    static final Logger LOGGER = Logger.getLogger(QuoteService.class.getName());
    
    public Quote getQuote() {
        
        Quote quote = holder.get("gturnquist-quoters.cfapps.io").getForObject( 
                "/api/random", Quote.class);
        LOGGER.info(quote.toString());
        return quote;
    }
    
}
